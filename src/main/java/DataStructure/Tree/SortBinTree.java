package DataStructure.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 排序二叉树的实现
 * 
 * @author JohnnyLiao
 * @date 2015年7月2日 下午3:59:04
 */
@SuppressWarnings("rawtypes")
public class SortBinTree<T extends Comparable> {

	// 三叉链表节点
	static class Node {
		Object data;
		Node left;
		Node right;
		Node parent;

		public Node(Object data, Node parent, Node left, Node right) {
			this.data = data;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "[data=" + data + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj.getClass() == Node.class) {
				Node target = (Node) obj;
				return data.equals(target.data) && left.equals(target.left) && right.equals(target.right) && parent.equals(target.parent);
			}
			return false;
		}
	}

	private Node root;

	public SortBinTree() {
		root = null;
	}

	public SortBinTree(T o) {
		root = new Node(o, null, null, null);
	}

	/**
	 * 添加节点-注意找到适合的位置以保证其为排序二叉树
	 * 
	 * @param ele
	 *            添加的新元素
	 */
	@SuppressWarnings("unchecked")
	public void add(T ele) {
		// 根节点为空，直接添加根节点
		if (root == null) {
			root = new Node(ele, null, null, null);
		} else {
			Node current = root;
			Node parent = null;
			int cmp = 0;
			// 搜索适合的叶子节点，以该叶子节点作为父节点添加新节点
			do {
				parent = current;
				cmp = ele.compareTo(current.data);
				if (cmp > 0) {
					current = current.right;
				} else {
					current = current.left;
				}

			} while (current != null);
			// 创建新节点
			Node newNode = new Node(ele, parent, null, null);
			// 如果新节点大于父节点
			if (cmp > 0) {
				parent.right = newNode;
			} else {
				parent.left = newNode;
			}
		}
	}

	/**
	 * 删除节点--分多钟情况处理--要维护删掉此节点后还是排序二叉树
	 * 
	 * @param ele
	 *            要删除的节点元素
	 */
	public void remove(T ele) {
		// 获取要删除的节点
		Node target = getNode(ele);

		if (target == null)
			return;

		// -----如果要删除的左、右子树为空的话-----
		if (target.left == null && target.right == null) {
			if (target == root) {
				root = null;
			} else {
				// 要删除的节点是父节点的左子节点
				if (target == target.parent.left) {
					// 父节点的左子节点置null
					target.parent.left = null;
				} else {
					// 父节点的右子节点置null
					target.parent.right = null;
				}
				// 本节点的父节点指针置null
				target.parent = null;
			}
		}
		// -----要删除的节点只有右节点-----
		else if (target.left == null && target.right != null) {
			if (target == root) {
				root = target.right;
			} else {
				/**
				 * 同下
				 */
				// 要删除的节点是父节点的左子节点
				if (target == target.parent.left) {
					// 让target的父节点的left（左指针）指向target的右子树
					target.parent.left = target.right;
				} else {
					// // 让target的父节点的right（右指针）指向target的右子树
					target.parent.right = target.right;
				}
				// 让target的右子树的parent（父指针）指向target的父节点
				target.right.parent = target.parent;
//				target.parent = target.right = null;
			}
		}
		// -----要删除的节点只有左节点-----
		else if (target.left != null && target.right == null) {
			if (target == root) {
				root = target.left;
			} else {

				/**
				 * 有错，遗留一个问题，有待解决，现在忙于学习新知识先。
				 */
				// 要删除的节点是父节点的左子节点
				if (target == target.parent.left) {
					// 让target的父节点的left（左指针）指向target的左子树
					target.parent.left = target.left;
				} else {
					// // 让target的父节点的right（右指针）指向target的左子树
					target.parent.right = target.left;
				}
				// 让target的左子树的parent（父指针）指向target的父节点
				target.left.parent = target.parent;
				
				/** 现在出错情况是：已经把目标节点的子树指向目标节点的父节点
				 * 					和把目标节点的父节点的子指针指向了目标节点的子节点
				 * 				但是目标节点的指针依然指向父节点及子树还不能轻易把这两个指针直接置空（会把现有位置上的节点去掉）。
				 */
//				target.parent = target.left = null;
//				target = null;
				System.out.println(target.parent.right);
				System.out.println(target.left.parent);
//				target.left = null;
				System.out.println(target.left);
				System.out.println(target + "+++++++++");
			}
		}
		// =====要删除的节点既有左子树，又有右子树=====
		/**
		 * 在左子树中找到最大节点来代替要删除的节点，记住：要判断左子树的分类情况：只是一个节点，左子树没有右节点（还是左子树的根节点最大），
		 * 左子树有右节点（最右节点值最大）。
		 */
		else {
			if (target == root) {
				throw new RuntimeException("移除目标节点为根节点，且有左、右子树，移除根后将变为森林，此处不做处理");
			}
			// 用leftMaxNode记录target节点的左子树中最大的节点
			Node leftMaxNode = target.left;
			
			// 先在此判断target.left的类型再做处理

			// 只是一个节点，没有形成子树
			if (leftMaxNode.left == null && leftMaxNode.right == null) {
				// 要删除的节点是父节点的左子节点
				if (target == target.parent.left) {
					target.parent.left = leftMaxNode;
				} else {
					target.parent.right = leftMaxNode;
				}
				leftMaxNode.parent = target.parent;
				leftMaxNode.right = target.right;
				leftMaxNode.left = null;
			}
			// 有左字节点，没有右子节点,此时还是初始的leftMaxNode最大
			else if (leftMaxNode.left != null && leftMaxNode.right == null) {
				// 要删除的节点是父节点的左子节点
				if (target == target.parent.left) {
					target.parent.left = leftMaxNode;
				} else {
					target.parent.right = leftMaxNode;
				}
				leftMaxNode.parent = target.parent;
				leftMaxNode.right = target.right;
			}
			// 都不为空和只有右不为空一样
			else {
				// 找到最大值
				while (leftMaxNode.right != null) {
					leftMaxNode = leftMaxNode.right;
				}
				leftMaxNode.parent.right = null;
				// 要删除的节点是父节点的左子节点
				if (target == target.parent.left) {
					target.parent.left = leftMaxNode;
				} else {
					target.parent.right = leftMaxNode;
				}
				leftMaxNode.parent = target.parent;
				leftMaxNode.left = target.left;
				leftMaxNode.right = target.right;
				// notice don't forget
				target.parent = target.left = target.right = null;
			}

		}

	}

	/**
	 * 根据给定的值搜索节点
	 * 
	 * @param ele
	 *            给定的值
	 * @return 节点
	 */
	@SuppressWarnings("unchecked")
	public Node getNode(T ele) {
		// begin with root
		Node p = root;
		while (p != null) {
			int cmp = ele.compareTo(p.data);
			if (cmp < 0) {
				// 向左子树搜索
				p = p.left;
			} else if (cmp > 0) {
				// 向右子树搜索
				p = p.right;
			} else {
				return p;
			}
		}
		return null;
	}

	// 广度优先遍历
	public List<Node> breadthFirst() {
		List<Node> list = new ArrayList<>();
		Queue<Node> queue = new ArrayDeque<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			// 将该队列“队尾”元素添加到List中
			list.add(queue.peek()); // 加入并不删除队列中元素
			Node p = queue.poll(); // 取出并删除队列中元素
			if (p.left != null) {
				queue.offer(p.left);
			}
			if (p.right != null) {
				queue.offer(p.right);
			}
		}
		return list;
	}

	// 中序遍历
	public List<Node> inIterator() {
		return inIterator(root);
	}

	private List<Node> inIterator(Node node) {
		List<Node> list = new ArrayList<Node>();

		// 左
		if (node.left != null) {
			list.addAll(inIterator(node.left));
		}

		// 根
		list.add(node);

		// 右
		if (node.right != null) {
			list.addAll(inIterator(node.right));
		}

		return list;
	}

}
