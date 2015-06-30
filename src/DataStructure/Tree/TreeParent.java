package DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ĸ��ڵ��ʾ��ʵ��
 * 
 * @author JohnnyLiao
 * 
 * @param <E>
 */
public class TreeParent<E> {
	public static class Node<T> {
		T data;
		int parent; // ��¼���ڵ��λ��

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
	private Node<E>[] nodes;		// ��¼���������нڵ�-ÿ���ڵ����Ͷ���E
	private int nodeNums; 			// ��¼�ڵ���
	
	// -----������-----
	
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
	
	// Ϊָ���ڵ�����ӽڵ�
	public void addNode(E data, Node parent) {
		for (int i = 0; i < treeSize; i++) {
			if (nodes[i] == null) {
				nodes[i] = new Node<E>(data, pos(parent));
				nodeNums++;
				return;
			}
		}
		throw new RuntimeException("�����������޷�����½ڵ�");
	}

	// ���ذ���ָ��ֵ�Ľڵ��λ��
	public int pos(Node node) {		
		for (int i = 0; i < treeSize; i++) {
			// �ҵ�ָ���ڵ�
			if (nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}
	
	// �ж����Ƿ�Ϊ��
	public boolean empty() {
		// ���ڵ��Ƿ�Ϊ��
		return nodes[0] == null;
	}
	
	// ���ظ��ڵ�
	public Node<E> root() {
		return nodes[0];
	}
	
	// ����ָ���ڵ�(�Ǹ��ڵ�)�ĸ��ڵ�
	public Node<E> parent(Node node) {
		return nodes[node.parent];
	}
	
	// ����ָ���ڵ�(��Ҷ�ӽڵ�)�������ӽڵ�
	public List<Node<E>> children(Node<E> parent) {
		List<Node<E>> list = new ArrayList<>();
		// -------------Ѱ���ӽڵ���Ҫ������������-----------------
		for (int i = 0; i < treeSize; i++) {
			// ��ǰ�ڵ�ĸ��ڵ��λ�� == parent�ڵ��λ��
			if (nodes[i] != null && nodes[i].parent == pos(parent)) {
				list.add(nodes[i]);
			}
		}
		return list;
	}
	
	// ���ظ��������
	public int deep() {
		// ��¼�ڵ��������
		int max = 0;
		// �����鿴ÿ���ڵ����ȣ���Ϊ����һ���Ƕ��������Բ��ܼ򵥵��Ż�Ϊ��Ҷ�ӽڵ㿪ʼ������
		for (int i = 0; i < treeSize && nodes[i] != null; i++) {
			// ��¼���νڵ�����--��ʼΪ1
			int def = 1;
			int m = nodes[i].parent;
			while(m != -1 && nodes[m] != null) {
				// ���ϼ����������ڵ�
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
