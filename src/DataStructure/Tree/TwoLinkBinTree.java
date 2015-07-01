package DataStructure.Tree;

/**
 * 二叉树的二叉链表存储实现
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
	
	// 以指定元素创建二叉树
	public TwoLinkBinTree(E data) {
		this.root = new TreeNode(data);
	}
	
	/**
	 * 为指定节点添加子节点
	 * @param parent 需要添加子节点的父节点索引
	 * @param data 子节点的数据
	 * @param isLeft 是否为左子节点
	 * @return 新增加的节点
	 */
	public TreeNode addNode(TreeNode parent, E data, boolean isLeft) {
		if (parent == null) 
			throw new RuntimeException("节点为null,无法添加子节点");
		if (isLeft && parent.left != null)
			throw new RuntimeException(parent + "节点以有左子节点，无法添加左子节点");
		if (!isLeft && parent.right != null) 
			throw new RuntimeException(parent + "节点有右子节点，无法添加右子节点");
		
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
			throw new RuntimeException("树为空，无法访问根节点");
		return root;
	}
	
	/**
	 * 返回指定节点(非根节点)的父节点
	 * @param data 指定节点
	 * @return 指定节点的父节点 或 null
	 */
	public TreeNode parent(TreeNode node) {
		if (node == null)
			throw new RuntimeException("节点为空，无法访问父节点");
		if (node == root())
			throw new RuntimeException("节点为根节点，没有父节点");
		
		return parent(root, node);	// 递归从root子树（整棵树）中查找node的父节点
	}
	
	/**
	 * 递归算法：递归从子树中找出节点的父节点
	 * @param subTree 需递归查找的子树
	 * @param node 查找的节点
	 * @return 节点的父节点
	 */
	private TreeNode parent(TreeNode subTree, TreeNode node) {
		if (subTree == null)
			return null;
		if (subTree.left == node || subTree.right == node)
			return subTree;		// 找到返回父节点地址
		TreeNode p;
		// 先从左子树找，没找到从右子树找
		if ((p = parent(subTree.left, node)) != null)
			return p;
		else 
			return parent(subTree.right, node);
	}

// +++++开始设计的递归算法，但是没把子树传入，导致总是会返回根节点.----------设计上的失败，保留，起警示作用-----------------
/*	// 返回指定节点(非根节点)的父节点
	public E parent(TreeNode data) {
		if (data == root())
			throw new RuntimeException("节点为根节点，没有父节点");
		
		// 需要遍历二叉树来找到父节点--此处采用前序遍历来查找父节点
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
			tmp = root();		// 使其从根开始遍历
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
// +++++开始设计的递归算法，但是没把子树传入，导致总是会返回根节点.----------设计上的失败，保留，起警示作用-----------------
	
	// 返回指定节点的左子节点，不存在返回null
	@SuppressWarnings("unchecked")
	public E leftChild(TreeNode parent) {
		if (parent == null)
			throw new RuntimeException("节点为null,没有子节点");
		return parent.left == null ? null : (E) parent.left.data;
	}
	
	// 返回指定节点的右子节点，不存在返回null
	@SuppressWarnings("unchecked")
	public E rightChild(TreeNode parent) {
		if (parent == null)
			throw new RuntimeException("节点为null,没有子节点");
		return parent.right == null ? null : (E) parent.right.data;
	}
	
	public int deep() {
		return deep(root);
	}

	// 递归方法：每棵子树的深度为其所有子树的深度+1
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
