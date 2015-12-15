package DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;


/**
 * �����ӽڵ�����ʾ��
 * 
 * @author JohnnyLiao
 * 
 * @param <E>
 */
public class TreeChild<E> {

	// �ӽڵ�ṹ
	public static class SonNode {
		// ��¼��ǰ�ڵ��λ��
		private int pos;
		private SonNode next;
		
		public SonNode(int pos, SonNode next) {
			this.pos = pos;
			this.next = next;
		}
	}
	
	// �ڵ�ṹ
	public static class Node<T> {
		T data;
		// ��¼��һ���ӽڵ�
		SonNode first;
		
		public Node(T data) {
			this.data = data;
			this.first = null;
		}
		
		@Override
		public String toString() {
			if (first != null) {
				return "TreeChild$Node[data=" + data + ", first=" + first.pos + "]";
			} else {
				return "TreeChild$Node[data=" + data + ", first=-1]";
			}
		}
	}

	private final int DEFAULT_TREE_SIZE = 100; 
	private int treeSize = 0;
	private Node<E>[] nodes;		// ��¼���������нڵ�-ÿ���ڵ����Ͷ���E
	private int nodeNums; 			// ��¼�ڵ���
	
	//-----������-----
	
	@SuppressWarnings("unchecked")
	public TreeChild(E data) {
		treeSize = DEFAULT_TREE_SIZE;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data);
		nodeNums++;
	}
	
	@SuppressWarnings("unchecked")
	public TreeChild(E data, int treeSize) {
		this.treeSize = treeSize;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data);
		nodeNums++;
	}
	
	// Ϊָ���ڵ�����ӽڵ�
	public void addNode(E data, Node<E> parent) {
		for (int i = 0; i < treeSize; i++) {
			// �ҵ������е�һ��Ϊ�յ�Ԫ�أ���Ԫ�ر����½ڵ�
			if (nodes[i] == null) {
				nodes[i] = new Node<E>(data);
				if (parent.first == null) {
					parent.first = new SonNode(i, null);
				} else {
					SonNode next = parent.first;
					// �ҵ����һ���ӽڵ�
					while (next.next != null) {
						next = next.next;
					}
					// ���һ���ӽڵ��next��ָ��SonNode
					next.next = new SonNode(i, null);
				}
				nodeNums++;
				return;
			}
		}
		throw new RuntimeException("�����������޷�����½ڵ�");
	}
	
	// �ж����Ƿ�Ϊ��
	public boolean empty() {
		return nodes[0] == null;
	}
	
	// ���ظ��ڵ�
	public Node<E> root() {
		return nodes[0];
	}
	
	// ����ָ���ڵ㣨��Ҷ�ӽڵ㣩�������ӽڵ�---ֻ������ӽڵ���
	public List<Node<E>> children(Node<E> parent) {
		List<Node<E>> list = new ArrayList<>();
		SonNode next = parent.first;
		while (next != null) {
			list.add(nodes[next.pos]);
			next = next.next;
		}
		return list;
	}
	
	// ����ָ���ڵ�ĵ�index���ӽڵ�
	public Node<E> getChildForIndex(Node<E> parent, int index) {
		SonNode next = parent.first;
		// ���ź���������������һ�����ӽڵ�
		for (int i = 0; next != null; i++) {
			if (index == i) {
				return nodes[next.pos];
			}
			next = next.next;
		}
		return null;
	}
	
	// �����ӽڵ��ȡ���ڵ�
	public Node<E> parent(Node<E> child) {
		for (int i = 0; i < treeSize; i++) {
			if (nodes[i] != null) {
				// ���ӽڵ�������ӽڵ��ҵ����Ӧ�ĸ��ڵ�
				if (nodes[i].first != null) {
					SonNode next = nodes[i].first;
					while (next != null) {
						if (nodes[next.pos] == child) {
							return nodes[i];				// ���ص�������ӽڵ����ĸ��ڵ�
						}
						next = next.next;
					}
				}
			}
		}
		return null;
	}
	
	// �����������
	public int deep() {
		return deep(root());
	}

	// ����һ���ݹ鷽����ÿ�����������Ϊ������������������+1
	public int deep(Node<E> node) {
		if (node.first == null) {
			return 1;
		} else {
			int max = 0;
			SonNode next = node.first;
			while (next != null) {
				// ��ȡ�����ӽڵ�Ϊ����������������
				int tmp = deep(nodes[next.pos]);
				if (tmp > max) {
					max = tmp;
				}
				next = next.next;
			}
			return max + 1;
		}
	}
	
	// ���ذ���ָ��ֵ�Ľڵ�
	public int pos(Node<E> node) {
		for (int i = 0; i < treeSize; i++) {
			if (nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}

}
