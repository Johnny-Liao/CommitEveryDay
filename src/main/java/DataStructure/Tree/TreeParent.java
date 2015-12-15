package DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的父节点表示法实现
 * 
 * @author JohnnyLiao
 * 
 * @param <E>
 */
public class TreeParent<E> {
	public static class Node<T> {
		T data;
		int parent; // 记录父节点的位置

		public Node() {
		}

		public Node(T data) {
			this.data = data;
		}

		public Node(T data, int parent) {
			this.data = data;
			this.parent = parent;
		}
		
		@Override
		public String toString() {
			return "TreeParent$Node[data=" + data + ", parent=" + parent + "]";
		}
	}
	
	private final int DEFAULT_TREE_SIZE = 100; 
	private int treeSize = 0;
	private Node<E>[] nodes;		// 记录该树中所有节点-每个节点类型都是E
	private int nodeNums; 			// 记录节点数
	
	// -----创建树-----
	
	@SuppressWarnings("unchecked")
	public TreeParent(E data) {
		treeSize = DEFAULT_TREE_SIZE;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data, -1);
		nodeNums++;
	}
	
	@SuppressWarnings("unchecked")
	public TreeParent(E data, int treeSize) {
		this.treeSize = treeSize;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data, -1);
		nodeNums++;
	}
	
	// 为指定节点添加子节点
	public void addNode(E data, Node parent) {
		for (int i = 0; i < treeSize; i++) {
			if (nodes[i] == null) {
				nodes[i] = new Node<E>(data, pos(parent));
				nodeNums++;
				return;
			}
		}
		throw new RuntimeException("该树已满，无法添加新节点");
	}

	// 返回包含指定值的节点的位置
	public int pos(Node node) {		
		for (int i = 0; i < treeSize; i++) {
			// 找到指定节点
			if (nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}
	
	// 判断树是否为空
	public boolean empty() {
		// 根节点是否为空
		return nodes[0] == null;
	}
	
	// 返回根节点
	public Node<E> root() {
		return nodes[0];
	}
	
	// 返回指定节点(非根节点)的父节点
	public Node<E> parent(Node node) {
		return nodes[node.parent];
	}
	
	// 返回指定节点(非叶子节点)的所有子节点
	public List<Node<E>> children(Node<E> parent) {
		List<Node<E>> list = new ArrayList<>();
		// -------------寻找子节点需要遍历整个数组-----------------
		for (int i = 0; i < treeSize; i++) {
			// 当前节点的父节点的位置 == parent节点的位置
			if (nodes[i] != null && nodes[i].parent == pos(parent)) {
				list.add(nodes[i]);
			}
		}
		return list;
	}
	
	// 返回该树的深度
	public int deep() {
		// 记录节点的最大深度
		int max = 0;
		// 遍历查看每个节点的深度（此为树不一定是二叉树所以不能简单的优化为从叶子节点开始遍历）
		for (int i = 0; i < treeSize && nodes[i] != null; i++) {
			// 记录本次节点的深度--初始为1
			int def = 1;
			int m = nodes[i].parent;
			while(m != -1 && nodes[m] != null) {
				// 向上继续搜索父节点
				m = nodes[m].parent;
				def++;
			}
			if (max < def) {
				max = def;
			}
		}
		return max;
	}
}
