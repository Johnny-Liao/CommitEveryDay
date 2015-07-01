package DataStructure.Tree;

import java.util.Arrays;

/**
 * ��������˳��洢��ʽʵ��
 * 
 * @author JohnnyLiao
 */
public class ArrayBinTree<T> {

	private final int DEFAULT_DEEP = 8;

	private Object[] datas; // ʹ����������¼�������нڵ�
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
	
	// ��ָ�����ָ�����ڵ㴴��������
	public ArrayBinTree(int deep, T data) {
		this.deep = deep;
		this.arraySize = (int) Math.pow(2, deep) - 1; // 2*2*2...deep....*2 - 1
		datas = new Object[arraySize];
		datas[0] = data;
	}
	
	/**
	 * Ϊָ���ڵ�����ӽڵ�
	 * @param index ��Ҫ����ӽڵ�ĸ��ڵ������
	 * @param data �ӽڵ������
	 * @param left �Ƿ�Ϊ��ڵ�
	 */
	public void add(int index, T data, boolean left) {
		if (datas[index] == null)
			throw new RuntimeException(index + "�ڵ�Ϊ�գ��޷�����ӽڵ�");
		if (2 * index + 1 >= arraySize) 
			throw new RuntimeException("�ײ�������������Խ���쳣");
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
	
	// ����ָ���ڵ�����ӽڵ�
	@SuppressWarnings("unchecked")
	public T left(int index) {
		if (2 * index + 1 >= arraySize) 
			throw new RuntimeException("���ӽڵ�ΪҶ�ӽڵ㣬���ӽڵ�");
		return (T) datas[2 * index + 1];
	}
	
	// ����ָ���ڵ�����ӽڵ�
	@SuppressWarnings("unchecked")
	public T right(int index) {
		if (2 * index + 1 >= arraySize) 
			throw new RuntimeException("���ӽڵ�ΪҶ�ӽڵ㣬���ӽڵ�");
		return (T) datas[2 * index + 2];
	}
	
	public int deep() {
		return this.deep;
	}
	
	// ����ָ���ڵ��λ��
	public int pos(T data) {
		// ��ѭ��ʵ���Ͼ��ǰ���ȱ���������ÿ���ڵ�
		for (int i = 0; i < arraySize; i++) {
			// ע�⣺Ҫ�ж��Ƿ�Ϊ�գ��������NullPointException
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
