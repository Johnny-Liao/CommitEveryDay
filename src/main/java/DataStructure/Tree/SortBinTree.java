package DataStructure.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * �����������ʵ��
 * 
 * @author JohnnyLiao
 * @date 2015��7��2�� ����3:59:04
 */
@SuppressWarnings("rawtypes")
public class SortBinTree<T extends Comparable> {

	// ��������ڵ�
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
	 * ��ӽڵ�-ע���ҵ��ʺϵ�λ���Ա�֤��Ϊ���������
	 * 
	 * @param ele
	 *            ��ӵ���Ԫ��
	 */
	@SuppressWarnings("unchecked")
	public void add(T ele) {
		// ���ڵ�Ϊ�գ�ֱ����Ӹ��ڵ�
		if (root == null) {
			root = new Node(ele, null, null, null);
		} else {
			Node current = root;
			Node parent = null;
			int cmp = 0;
			// �����ʺϵ�Ҷ�ӽڵ㣬�Ը�Ҷ�ӽڵ���Ϊ���ڵ�����½ڵ�
			do {
				parent = current;
				cmp = ele.compareTo(current.data);
				if (cmp > 0) {
					current = current.right;
				} else {
					current = current.left;
				}

			} while (current != null);
			// �����½ڵ�
			Node newNode = new Node(ele, parent, null, null);
			// ����½ڵ���ڸ��ڵ�
			if (cmp > 0) {
				parent.right = newNode;
			} else {
				parent.left = newNode;
			}
		}
	}

	/**
	 * ɾ���ڵ�--�ֶ����������--Ҫά��ɾ���˽ڵ�������������
	 * 
	 * @param ele
	 *            Ҫɾ���Ľڵ�Ԫ��
	 */
	public void remove(T ele) {
		// ��ȡҪɾ���Ľڵ�
		Node target = getNode(ele);

		if (target == null)
			return;

		// -----���Ҫɾ������������Ϊ�յĻ�-----
		if (target.left == null && target.right == null) {
			if (target == root) {
				root = null;
			} else {
				// Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
				if (target == target.parent.left) {
					// ���ڵ�����ӽڵ���null
					target.parent.left = null;
				} else {
					// ���ڵ�����ӽڵ���null
					target.parent.right = null;
				}
				// ���ڵ�ĸ��ڵ�ָ����null
				target.parent = null;
			}
		}
		// -----Ҫɾ���Ľڵ�ֻ���ҽڵ�-----
		else if (target.left == null && target.right != null) {
			if (target == root) {
				root = target.right;
			} else {
				/**
				 * ͬ��
				 */
				// Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
				if (target == target.parent.left) {
					// ��target�ĸ��ڵ��left����ָ�룩ָ��target��������
					target.parent.left = target.right;
				} else {
					// // ��target�ĸ��ڵ��right����ָ�룩ָ��target��������
					target.parent.right = target.right;
				}
				// ��target����������parent����ָ�룩ָ��target�ĸ��ڵ�
				target.right.parent = target.parent;
//				target.parent = target.right = null;
			}
		}
		// -----Ҫɾ���Ľڵ�ֻ����ڵ�-----
		else if (target.left != null && target.right == null) {
			if (target == root) {
				root = target.left;
			} else {

				/**
				 * �д�����һ�����⣬�д����������æ��ѧϰ��֪ʶ�ȡ�
				 */
				// Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
				if (target == target.parent.left) {
					// ��target�ĸ��ڵ��left����ָ�룩ָ��target��������
					target.parent.left = target.left;
				} else {
					// // ��target�ĸ��ڵ��right����ָ�룩ָ��target��������
					target.parent.right = target.left;
				}
				// ��target����������parent����ָ�룩ָ��target�ĸ��ڵ�
				target.left.parent = target.parent;
				
				/** ���ڳ�������ǣ��Ѿ���Ŀ��ڵ������ָ��Ŀ��ڵ�ĸ��ڵ�
				 * 					�Ͱ�Ŀ��ڵ�ĸ��ڵ����ָ��ָ����Ŀ��ڵ���ӽڵ�
				 * 				����Ŀ��ڵ��ָ����Ȼָ�򸸽ڵ㼰�������������װ�������ָ��ֱ���ÿգ��������λ���ϵĽڵ�ȥ������
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
		// =====Ҫɾ���Ľڵ����������������������=====
		/**
		 * �����������ҵ����ڵ�������Ҫɾ���Ľڵ㣬��ס��Ҫ�ж��������ķ��������ֻ��һ���ڵ㣬������û���ҽڵ㣨�����������ĸ��ڵ���󣩣�
		 * ���������ҽڵ㣨���ҽڵ�ֵ��󣩡�
		 */
		else {
			if (target == root) {
				throw new RuntimeException("�Ƴ�Ŀ��ڵ�Ϊ���ڵ㣬���������������Ƴ����󽫱�Ϊɭ�֣��˴���������");
			}
			// ��leftMaxNode��¼target�ڵ�������������Ľڵ�
			Node leftMaxNode = target.left;
			
			// ���ڴ��ж�target.left��������������

			// ֻ��һ���ڵ㣬û���γ�����
			if (leftMaxNode.left == null && leftMaxNode.right == null) {
				// Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
				if (target == target.parent.left) {
					target.parent.left = leftMaxNode;
				} else {
					target.parent.right = leftMaxNode;
				}
				leftMaxNode.parent = target.parent;
				leftMaxNode.right = target.right;
				leftMaxNode.left = null;
			}
			// �����ֽڵ㣬û�����ӽڵ�,��ʱ���ǳ�ʼ��leftMaxNode���
			else if (leftMaxNode.left != null && leftMaxNode.right == null) {
				// Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
				if (target == target.parent.left) {
					target.parent.left = leftMaxNode;
				} else {
					target.parent.right = leftMaxNode;
				}
				leftMaxNode.parent = target.parent;
				leftMaxNode.right = target.right;
			}
			// ����Ϊ�պ�ֻ���Ҳ�Ϊ��һ��
			else {
				// �ҵ����ֵ
				while (leftMaxNode.right != null) {
					leftMaxNode = leftMaxNode.right;
				}
				leftMaxNode.parent.right = null;
				// Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
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
	 * ���ݸ�����ֵ�����ڵ�
	 * 
	 * @param ele
	 *            ������ֵ
	 * @return �ڵ�
	 */
	@SuppressWarnings("unchecked")
	public Node getNode(T ele) {
		// begin with root
		Node p = root;
		while (p != null) {
			int cmp = ele.compareTo(p.data);
			if (cmp < 0) {
				// ������������
				p = p.left;
			} else if (cmp > 0) {
				// ������������
				p = p.right;
			} else {
				return p;
			}
		}
		return null;
	}

	// ������ȱ���
	public List<Node> breadthFirst() {
		List<Node> list = new ArrayList<>();
		Queue<Node> queue = new ArrayDeque<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			// ���ö��С���β��Ԫ����ӵ�List��
			list.add(queue.peek()); // ���벢��ɾ��������Ԫ��
			Node p = queue.poll(); // ȡ����ɾ��������Ԫ��
			if (p.left != null) {
				queue.offer(p.left);
			}
			if (p.right != null) {
				queue.offer(p.right);
			}
		}
		return list;
	}

	// �������
	public List<Node> inIterator() {
		return inIterator(root);
	}

	private List<Node> inIterator(Node node) {
		List<Node> list = new ArrayList<Node>();

		// ��
		if (node.left != null) {
			list.addAll(inIterator(node.left));
		}

		// ��
		list.add(node);

		// ��
		if (node.right != null) {
			list.addAll(inIterator(node.right));
		}

		return list;
	}

}
