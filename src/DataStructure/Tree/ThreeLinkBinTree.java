package DataStructure.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的三叉链表存储: <br>
 * 和二叉链表存储方式仅3处不同：1.TreeNode多一个parent指针。2.addNode中要添加新节点指向父节点指针。3.parent()方法实行更便捷。
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

	// 以指定元素创建二叉树
	public ThreeLinkBinTree(E data) {
		this.root = new TreeNode(data);
	}

	/**
	 * 为指定节点添加子节点
	 * 
	 * @param parent
	 *            需要添加子节点的父节点索引
	 * @param data
	 *            子节点的数据
	 * @param isLeft
	 *            是否为左子节点
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
		newNode.parent = parent; // 让新节点的parent引用指向新节点
		return newNode;
	}

	public boolean empty() {
		return root.data == null;
	}

	public TreeNode root() {
		if (empty())
			throw new RuntimeException("树为空，无法访问根节点");
		return root;
	}

	// 访问指定节点（非根节点）的父节点
	@SuppressWarnings("unchecked")
	public E parent(TreeNode node) {
		if (node == root())
			throw new RuntimeException("节点为根节点，没有父节点");
		if (node == null)
			throw new RuntimeException("节点为空，无法访问父节点");
		return (E) node.parent.data;
	}

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
	
	
	//-----------------以下实现各种遍历方法--------------------//
	
	
	//----------------- 实现前序遍历--------------------
	public List<TreeNode> preIterator() {
		return preIrerator(root);
	}

	private List<TreeNode> preIrerator(TreeNode node) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		// 根
		list.add(node);
		
		// 左
		if(node.left != null) {
			list.addAll(preIrerator(node.left));
		}
		
		// 右
		if(node.right != null) {
			list.addAll(preIrerator(node.right));
		}
		
		return list;
	}
	
	//------------------- 实现中序遍历 -----------------
	public List<TreeNode> inIterator() {
		return inIterator(root);
	}

	private List<TreeNode> inIterator(TreeNode node) {
		List<TreeNode> list = new ArrayList<TreeNode>();

		// 左
		if(node.left != null) {
			list.addAll(inIterator(node.left));
		}
		
		// 根
		list.add(node);
		
		// 右
		if(node.right != null) {
			list.addAll(inIterator(node.right));
		}
		
		return list;
	}
	
	
	//------------------- 实现后序遍历 -----------------
	public List<TreeNode> postIterator() {
		return postIterator(root);
	}

	private List<TreeNode> postIterator(TreeNode node) {
		List<TreeNode> list = new ArrayList<TreeNode>();

		// 左
		if(node.left != null) {
			list.addAll(postIterator(node.left));
		}
		
		// 右
		if(node.right != null) {
			list.addAll(postIterator(node.right));
		}
		
		// 根
		list.add(node);

		return list;
	}
	
	//------------------- 实现层次（广度优先）遍历 -----------------
	public List<TreeNode> breathFirst() {
		List<TreeNode> list = new ArrayList<TreeNode>();
		// 借助FIFO的队列来实现
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();			// deque:double-ended queue 双端队列
		if (root != null) {
			queue.offer(root);
		}
		
		while (!queue.isEmpty()) {
			// 将队列的头部元素添加到list中
			list.add(queue.peek());
			// 将该队列的“头部”元素移出队列
			TreeNode p = queue.poll();
			// 如果左子节点不为空，将它加入队列
			if (p.left != null) {
				queue.offer(p.left);
			}
			// 如果右子节点不为空，将它加入队列
			if (p.right != null) {
				queue.offer(p.right);
			}
		}
		return list;
	}
	
	//-----------------以上实现各种遍历方法--------------------//
}
