package DataStructure.Tree;

import java.util.Arrays;

/**
 * 二叉树的顺序存储方式实现
 * 
 * @author JohnnyLiao
 */
public class ArrayBinTree<T> {

	private final int DEFAULT_DEEP = 8;

	private Object[] datas; // 使用数组来记录树的所有节点
	private int deep;
	private int arraySize;

	public ArrayBinTree() {
		this.deep = DEFAULT_DEEP;
		this.arraySize = (int) Math.pow(2, deep) - 1; // 2*2*2...deep....*2 - 1
		datas = new Object[arraySize];
	}
	
	public ArrayBinTree(int deep) {
		this.deep = deep;
		this.arraySize = (int) Math.pow(2, deep) - 1; // 2*2*2...deep....*2 - 1
		datas = new Object[arraySize];
	}
	
	// 以指定深度指定根节点创建二叉树
	public ArrayBinTree(int deep, T data) {
		this.deep = deep;
		this.arraySize = (int) Math.pow(2, deep) - 1; // 2*2*2...deep....*2 - 1
		datas = new Object[arraySize];
		datas[0] = data;
	}
	
	/**
	 * 为指定节点添加子节点
	 * @param index 需要添加子节点的父节点的索引
	 * @param data 子节点的数据
	 * @param left 是否为左节点
	 */
	public void add(int index, T data, boolean left) {
		if (datas[index] == null)
			throw new RuntimeException(index + "节点为空，无法添加子节点");
		if (2 * index + 1 >= arraySize) 
			throw new RuntimeException("底层数组已满，树越界异常");
		if (left) {
			datas[2 * index + 1] = data;
		} else {
			datas[2 * index + 2] = data;
		}
	}
	
	public boolean empty() {
		return datas[0] == null;
	}
	
	@SuppressWarnings("unchecked")
	public T root() {
		return (T) datas[0];
	}
	
	@SuppressWarnings("unchecked")
	public T parent(int index) {
		return (T) datas[(index - 1) / 2];
	}
	
	// 返回指定节点的左子节点
	@SuppressWarnings("unchecked")
	public T left(int index) {
		if (2 * index + 1 >= arraySize) 
			throw new RuntimeException("该子节点为叶子节点，无子节点");
		return (T) datas[2 * index + 1];
	}
	
	// 返回指定节点的右子节点
	@SuppressWarnings("unchecked")
	public T right(int index) {
		if (2 * index + 1 >= arraySize) 
			throw new RuntimeException("该子节点为叶子节点，无子节点");
		return (T) datas[2 * index + 2];
	}
	
	public int deep() {
		return this.deep;
	}
	
	// 返回指定节点的位置
	public int pos(T data) {
		// 该循环实际上就是按广度遍历来搜索每个节点
		for (int i = 0; i < arraySize; i++) {
			// 注意：要判断是否为空，否则会有NullPointException
			if (datas[i] != null)
				if (datas[i].equals(data))
					return i;
		}
		return -1;
	}
	
	public String toString() {
		return Arrays.toString(datas);
	}

}
