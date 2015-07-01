package DataStructure.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * ����������������洢: <br>
 * �Ͷ�������洢��ʽ��3����ͬ��1.TreeNode��һ��parentָ�롣2.addNode��Ҫ����½ڵ�ָ�򸸽ڵ�ָ�롣3.parent()����ʵ�и���ݡ�
 * 
 * @author JohnnyLiao
 */
public class ThreeLinkBinTree<E> {

	public static class TreeNode {
		Object data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		public TreeNode() {
		}

		public TreeNode(Object data) {
			this.data = data;
		}

		public TreeNode(Object data, TreeNode left, TreeNode right, TreeNode parent) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		
		@Override
		public String toString() {
			return (String) data;
		}
	}

	private TreeNode root;

	public ThreeLinkBinTree() {
		this.root = new TreeNode();
	}

	// ��ָ��Ԫ�ش���������
	public ThreeLinkBinTree(E data) {
		this.root = new TreeNode(data);
	}

	/**
	 * Ϊָ���ڵ�����ӽڵ�
	 * 
	 * @param parent
	 *            ��Ҫ����ӽڵ�ĸ��ڵ�����
	 * @param data
	 *            �ӽڵ������
	 * @param isLeft
	 *            �Ƿ�Ϊ���ӽڵ�
	 * @return �����ӵĽڵ�
	 */
	public TreeNode addNode(TreeNode parent, E data, boolean isLeft) {
		if (parent == null)
			throw new RuntimeException("�ڵ�Ϊnull,�޷�����ӽڵ�");
		if (isLeft && parent.left != null)
			throw new RuntimeException(parent + "�ڵ��������ӽڵ㣬�޷�������ӽڵ�");
		if (!isLeft && parent.right != null)
			throw new RuntimeException(parent + "�ڵ������ӽڵ㣬�޷�������ӽڵ�");

		TreeNode newNode = new TreeNode(data);
		if (isLeft)
			parent.left = newNode;
		else
			parent.right = newNode;
		newNode.parent = parent; // ���½ڵ��parent����ָ���½ڵ�
		return newNode;
	}

	public boolean empty() {
		return root.data == null;
	}

	public TreeNode root() {
		if (empty())
			throw new RuntimeException("��Ϊ�գ��޷����ʸ��ڵ�");
		return root;
	}

	// ����ָ���ڵ㣨�Ǹ��ڵ㣩�ĸ��ڵ�
	@SuppressWarnings("unchecked")
	public E parent(TreeNode node) {
		if (node == root())
			throw new RuntimeException("�ڵ�Ϊ���ڵ㣬û�и��ڵ�");
		if (node == null)
			throw new RuntimeException("�ڵ�Ϊ�գ��޷����ʸ��ڵ�");
		return (E) node.parent.data;
	}

	// ����ָ���ڵ�����ӽڵ㣬�����ڷ���null
	@SuppressWarnings("unchecked")
	public E leftChild(TreeNode parent) {
		if (parent == null)
			throw new RuntimeException("�ڵ�Ϊnull,û���ӽڵ�");
		return parent.left == null ? null : (E) parent.left.data;
	}

	// ����ָ���ڵ�����ӽڵ㣬�����ڷ���null
	@SuppressWarnings("unchecked")
	public E rightChild(TreeNode parent) {
		if (parent == null)
			throw new RuntimeException("�ڵ�Ϊnull,û���ӽڵ�");
		return parent.right == null ? null : (E) parent.right.data;
	}

	public int deep() {
		return deep(root);
	}

	// �ݹ鷽����ÿ�����������Ϊ���������������+1
	private int deep(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		else {
			int leftDeep = deep(node.left);
			int rightDeep = deep(node.right);

			int max = leftDeep > rightDeep ? leftDeep : rightDeep;
			return max + 1;
		}
	}
	
	
	//-----------------����ʵ�ָ��ֱ�������--------------------//
	
	
	//----------------- ʵ��ǰ�����--------------------
	public List<TreeNode> preIterator() {
		return preIrerator(root);
	}

	private List<TreeNode> preIrerator(TreeNode node) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		// ��
		list.add(node);
		
		// ��
		if(node.left != null) {
			list.addAll(preIrerator(node.left));
		}
		
		// ��
		if(node.right != null) {
			list.addAll(preIrerator(node.right));
		}
		
		return list;
	}
	
	//------------------- ʵ��������� -----------------
	public List<TreeNode> inIterator() {
		return inIterator(root);
	}

	private List<TreeNode> inIterator(TreeNode node) {
		List<TreeNode> list = new ArrayList<TreeNode>();

		// ��
		if(node.left != null) {
			list.addAll(inIterator(node.left));
		}
		
		// ��
		list.add(node);
		
		// ��
		if(node.right != null) {
			list.addAll(inIterator(node.right));
		}
		
		return list;
	}
	
	
	//------------------- ʵ�ֺ������ -----------------
	public List<TreeNode> postIterator() {
		return postIterator(root);
	}

	private List<TreeNode> postIterator(TreeNode node) {
		List<TreeNode> list = new ArrayList<TreeNode>();

		// ��
		if(node.left != null) {
			list.addAll(postIterator(node.left));
		}
		
		// ��
		if(node.right != null) {
			list.addAll(postIterator(node.right));
		}
		
		// ��
		list.add(node);

		return list;
	}
	
	//------------------- ʵ�ֲ�Σ�������ȣ����� -----------------
	public List<TreeNode> breathFirst() {
		List<TreeNode> list = new ArrayList<TreeNode>();
		// ����FIFO�Ķ�����ʵ��
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();			// deque:double-ended queue ˫�˶���
		if (root != null) {
			queue.offer(root);
		}
		
		while (!queue.isEmpty()) {
			// �����е�ͷ��Ԫ����ӵ�list��
			list.add(queue.peek());
			// ���ö��еġ�ͷ����Ԫ���Ƴ�����
			TreeNode p = queue.poll();
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
	
	//-----------------����ʵ�ָ��ֱ�������--------------------//
}
