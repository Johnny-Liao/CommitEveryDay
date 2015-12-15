package DataStructure.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author JohnnyLiao
 * @date 2015��7��2�� ����2:04:35
 */
public class HuffmanTree {

	/**
	 * Node�ڵ� - ����Ȩ��ֵ
	 * @author JohnnyLiao
	 * @date 2015��7��2�� ����2:07:11
	 * @param <E>
	 *            Node����
	 */
	public static class Node<E> {
		E data;
		double weight;
		Node<E> left;
		Node<E> right;

		public Node(E data, double weight) {
			this.data = data;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node[data=" + data + ", weight=" + weight + "]";
		}
	}

	/**
	 * �����������
	 * 
	 * @param nodes
	 *            �ڵ㼯��
	 * @return ������Ĺ��������ĸ��ڵ�
	 */
	private static <E> Node<E> creatHuffmanTree(List<Node<E>> nodes) {
		// ֻҪnodes�����л����������Ͻڵ�--�������
		while (nodes.size() > 1) {
			quickSort(nodes);
			// ��ȡ��С�������ڵ�
			Node<E> left = nodes.get(nodes.size() - 1);
			Node<E> right = nodes.get(nodes.size() - 2);

			// �����½ڵ�
			Node<E> parent = new Node<>(null, left.weight + right.weight);
			parent.left = left;
			parent.right = right;

			// ɾ��Ȩֵ��С�������ڵ�
			nodes.remove(nodes.size() - 1);
			nodes.remove(nodes.size() - 1);
			
			// �������ɵĸ��ڵ���ӵ�����
			nodes.add(parent);
		}
		// ��󷵻�nodes������Ψһһ���ڵ㣬Ҳ���Ǹ��ڵ�
		return nodes.get(0);
	}

	/**
	 * ��������
	 * 
	 * @param nodes
	 *            �����nodes����
	 */
	private static <E> void quickSort(List<Node<E>> nodes) {
		subSort(nodes, 0, nodes.size() - 1);
	}

	private static <E> void subSort(List<Node<E>> nodes, int start, int end) {
		if (start < end) {
			// get the first one
			Node<E> base = nodes.get(start);
			int i = start;
			int j = end + 1;
			while (true) {
				while (i < end && nodes.get(++i).weight >= base.weight)
					; // ����
				while (j > start && nodes.get(--j).weight <= base.weight)
					;
				if (i < j) {
					swap(nodes, i, j);
				} else {
					break;
				}
			}
			swap(nodes, start, j);

			// recursive
			subSort(nodes, start, j - 1);
			subSort(nodes, j + 1, end);
		}
	}

	// ���ڽ��������ڵ�Ԫ��
	private static <E> void swap(List<Node<E>> nodes, int i, int j) {
		Node<E> tmp = nodes.get(i);
		nodes.set(i, nodes.get(j));
		nodes.set(j, tmp);
	}
	
	/**
	 * ������ȱ���
	 * @param root ������ڵ�
	 * @return �ź����Node����
	 */
	public static <E> List<Node<E>> breadthFirst(Node<E> root) {
		List<Node<E>> list = new ArrayList<Node<E>>();
		// ����FIFO�Ķ�����ʵ��
		Queue<Node<E>> queue = new ArrayDeque<Node<E>>();			// deque:double-ended queue ˫�˶���
		if (root != null) {
			queue.offer(root);
		}
		
		while (!queue.isEmpty()) {
			// �����е�ͷ��Ԫ����ӵ�list��
			list.add(queue.peek());
			// ���ö��еġ�ͷ����Ԫ���Ƴ�����
			Node<E> p = queue.poll();
			// ������ӽڵ㲻Ϊ�գ������������
			if (p.left != null) {
				queue.offer(p.left);
			}
			// ������ӽڵ㲻Ϊ�գ������������
			if (p.right != null) {
				queue.offer(p.right);
			}
		}
		return list;
	}
	
	// ����
	public static void main(String[] args) {
		List<Node<String>> nodes = new ArrayList<>();
		nodes.add(new Node<String>("A", 40.0));
		nodes.add(new Node<String>("B", 7.0));
		nodes.add(new Node<String>("C", 10.0));
		nodes.add(new Node<String>("D", 30.0));
		nodes.add(new Node<String>("E", 12.0));
		nodes.add(new Node<String>("F", 2.0));
		
		Node<String> root = HuffmanTree.creatHuffmanTree(nodes);
		System.out.println(breadthFirst(root));
		// ��ʽ�����-���ɵ�data=null�ĸ��ڵ㲻������ʾ
		List<Node<String>> iter = breadthFirst(root);
		for (Node<String> it : iter) {
			if (it.data != null) 
				System.out.println(it);
		}
	}
}
