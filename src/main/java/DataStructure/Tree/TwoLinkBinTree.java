package DataStructure.Tree;

/**
 * �������Ķ�������洢ʵ��
 * 
 * @author JohnnyLiao
 * 
 * @param <E>
 */
public class TwoLinkBinTree<E> {

	public static class TreeNode {
		Object data;
		TreeNode left;
		TreeNode right;

		public TreeNode() {
		}

		public TreeNode(Object data) {
			this.data = data;
		}

		public TreeNode(Object data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public String toString() {
			return (String) data;
		}
	}

	private TreeNode root;
	
	public TwoLinkBinTree() {
		this.root = new TreeNode();
	}
	
	// ��ָ��Ԫ�ش���������
	public TwoLinkBinTree(E data) {
		this.root = new TreeNode(data);
	}
	
	/**
	 * Ϊָ���ڵ�����ӽڵ�
	 * @param parent ��Ҫ����ӽڵ�ĸ��ڵ�����
	 * @param data �ӽڵ������
	 * @param isLeft �Ƿ�Ϊ���ӽڵ�
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
		return newNode;
	}
	
	public boolean empty() {
		return root.data == null;
	}
	
	public TreeNode root() {
		if(empty()) 
			throw new RuntimeException("��Ϊ�գ��޷����ʸ��ڵ�");
		return root;
	}
	
	/**
	 * ����ָ���ڵ�(�Ǹ��ڵ�)�ĸ��ڵ�
	 * @param data ָ���ڵ�
	 * @return ָ���ڵ�ĸ��ڵ� �� null
	 */
	public TreeNode parent(TreeNode node) {
		if (node == null)
			throw new RuntimeException("�ڵ�Ϊ�գ��޷����ʸ��ڵ�");
		if (node == root())
			throw new RuntimeException("�ڵ�Ϊ���ڵ㣬û�и��ڵ�");
		
		return parent(root, node);	// �ݹ��root���������������в���node�ĸ��ڵ�
	}
	
	/**
	 * �ݹ��㷨���ݹ���������ҳ��ڵ�ĸ��ڵ�
	 * @param subTree ��ݹ���ҵ�����
	 * @param node ���ҵĽڵ�
	 * @return �ڵ�ĸ��ڵ�
	 */
	private TreeNode parent(TreeNode subTree, TreeNode node) {
		if (subTree == null)
			return null;
		if (subTree.left == node || subTree.right == node)
			return subTree;		// �ҵ����ظ��ڵ��ַ
		TreeNode p;
		// �ȴ��������ң�û�ҵ�����������
		if ((p = parent(subTree.left, node)) != null)
			return p;
		else 
			return parent(subTree.right, node);
	}

// +++++��ʼ��Ƶĵݹ��㷨������û���������룬�������ǻ᷵�ظ��ڵ�.----------����ϵ�ʧ�ܣ���������ʾ����-----------------
/*	// ����ָ���ڵ�(�Ǹ��ڵ�)�ĸ��ڵ�
	public E parent(TreeNode data) {
		if (data == root())
			throw new RuntimeException("�ڵ�Ϊ���ڵ㣬û�и��ڵ�");
		
		// ��Ҫ�������������ҵ����ڵ�--�˴�����ǰ����������Ҹ��ڵ�
		return preIteratorToFindParent(data);
	}
	
	TreeNode tmpNode = null;
	boolean tag = true;
	TreeNode tmp = null;
	E result;
	//+++++++++++++++++++++++++++++++++++++++++++++++
	@SuppressWarnings("unchecked")
	private E preIteratorToFindParent(TreeNode node) {
		if (tag) {
			tmp = root();		// ʹ��Ӹ���ʼ����
			tag = false;
		}
		
		if (tmp.left != null) {
			if (tmp.left == node) {
				tmpNode = tmp;
				System.out.println(tmpNode.data);
				return (E) tmpNode.data;
//				return (E) tmp.data; 
			}
			result = preIteratorToFindParent(tmp.left);
		}
		if (tmp.right != null) {
			if (tmp.right == node) {
				tmpNode = tmp;
				return (E) tmpNode.data;
//				return (E) tmp.data;
			}
			result = preIteratorToFindParent(tmp.right);
		}
//		return (E) tmpNode.data;
		return result;
	}*/
// +++++��ʼ��Ƶĵݹ��㷨������û���������룬�������ǻ᷵�ظ��ڵ�.----------����ϵ�ʧ�ܣ���������ʾ����-----------------
	
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
}
