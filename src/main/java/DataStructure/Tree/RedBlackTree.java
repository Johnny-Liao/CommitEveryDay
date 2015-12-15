package DataStructure.Tree;

/**
 * �������ʵ��
 * 
 * @author JohnnyLiao
 * @date 2015��7��10�� ����5:07:04
 * @param <T>
 *            ��������
 */
@SuppressWarnings("rawtypes")
public class RedBlackTree<T extends Comparable> {

	private static final boolean RED = false;
	private static final boolean BLACK = true;

	static class Node {
		Object data;
		Node parent;
		Node left;
		Node right;
		boolean color = BLACK;

		public Node(Object data, Node parent, Node left, Node right) {
			this.data = data;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "[data=" + data + ", color=" + color + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj.getClass() == Node.class) {
				Node target = (Node) obj;
				return data.equals(target.data) && color == target.color && left == target.left && right == target.right && parent == target.parent;
			}
			return false;
		}
	}

	private Node root;

	public RedBlackTree() {
		root = null;
	}

	public RedBlackTree(T o) {
		root = new Node(o, null, null, null);
	}

	// add node
	@SuppressWarnings("unchecked")
	public void add(T ele) {
		// if is root
		if (root == null) {
			root = new Node(ele, null, null, null);
		} else {
			Node current = root;
			Node parent = null;
			int cmp = 0;
			// search the right node places to set the new node.
			do {
				parent = current;
				cmp = ele.compareTo(current.data);
				if (cmp > 0) {
					current = current.right;
				} else {
					current = current.left;
				}
			} while (current != null);
			Node newNode = new Node(ele, parent, null, null);
			if (cmp > 0) {
				parent.right = newNode;
			} else {
				parent.left = newNode;
			}
			// To maintain the characteristics of the red black tree
			fixAfterInsertion(newNode);
		}
	}

	// To maintain the characteristics of the red black tree when inserted a new
	// node
	private void fixAfterInsertion(Node x) {
		x.color = RED;
		// ���˵�����Ҫ�޸������
		while (x != null && x != root && x.parent.color != RED) {
			// �����ǰ�ڵ�ĸ��ڵ����游�ڵ�����ӽڵ�
			if (parentOf(x) == leftOf(parentOf(x))) {
				// get the uncle node
				Node uncle = rightOf(parentOf(x));
				// if uncle node's color == red
				/**
				 * colorOfĬ�Ϸ���BLACK���Բ����ڿյ����
				 */
				if (colorOf(uncle) == RED) {
					setColor(parentOf(x), BLACK);
					setColor(rightOf(parentOf(x)), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					// recursive the method to verify the grandfather node
					x = parentOf(parentOf(x));
				}
				// uncle node's color is black , when the uncle is null the uncle's color is still BLACK
				else {
					// x is parent's right-child node
					if (x == rightOf(parentOf(x))) {
						// rotate left x's parent node
						x = parentOf(x);
						rotateLeft(x);
					}
					/**
					 * �����ǲ����Һ��Ӷ���Ҫ�ⲽ����
					 */
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					rotateRight(parentOf(parentOf(x)));
				}
			}
			// �����ǰ�ڵ�ĸ��ڵ����游�ڵ�����ӽڵ�---��������������ڵ��෴������һ��
			else {
				// get the uncle node
				Node uncle = rightOf(parentOf(x));
				// uncle node's color is red
				if (colorOf(uncle) == RED) {
					setColor(parentOf(x), BLACK);
					setColor(rightOf(parentOf(x)), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					x = parentOf(parentOf(x));
				}
				// uncle node's color is black
				else {
					if (x == leftOf(parentOf(x))) {		//ע�ⷴ��
						x = parentOf(x);
						rotateRight(x);
					}
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					rotateLeft(parentOf(parentOf(x)));
				}
			}
		}
		// set root color to be black
		root.color = BLACK;
	}

	// remove a node
	public void remove(T ele) {
		Node target = getNode(ele);
		if (target.left != null && target.right != null) {
			// find the node just smaller then target
			Node s = target.left;
			while (s.right != null)
				s = s.right;
			target.data = s.data;
			target = s;
		}
		// begin fix
		Node replacement = (target.left != null ? target.left : target.right);
		if (replacement != null) {
			replacement.parent = target.parent;
			if (target.parent == null) 
				root = replacement;
			else if (target == target.parent.left)
				target.parent.left = replacement;
			else
				target.parent.right = replacement;
			// delete target
			target.parent = target.left = target.right = null;
			if (target.color == BLACK) 
				fixAfterDeletion(replacement);
		}
		else if (target.parent == null)
			root = null;
		else {	// target has no child
			if (target.color == BLACK)
				fixAfterDeletion(target);
			if (target.parent != null)
				if (target == target.parent.left)
					target.parent.left = null;
				else if (target == target.parent.right)
					target.parent.right = null;
			target.parent = null;
		}
			
	}

	private void fixAfterDeletion(Node x) {
		while (x != root && colorOf(x) == BLACK) {
			// x is the left-son child for it's parent
			if (x == leftOf(parentOf(x))) {
				Node sib = rightOf(parentOf(x));
				if (sib.color == RED) {
					setColor(sib, BLACK);
					setColor(parentOf(x), RED);
					rotateLeft(parentOf(x));
					sib = rightOf(parentOf(x));
				}
				if (colorOf(leftOf(sib)) == BLACK && colorOf(rightOf(sib)) == BLACK) {
					setColor(sib, RED);
					x = parentOf(x);
				}
			}
			// right-son child
			else {
				Node sib = leftOf(parentOf(x));
				if (sib.color == RED) {
					setColor(sib, BLACK);
					setColor(parentOf(x), RED);
					rotateRight(parentOf(x));
					sib = leftOf(parentOf(x));
				}
				if (colorOf(leftOf(sib)) == BLACK && colorOf(rightOf(sib)) == BLACK) {
					setColor(sib, RED);
					x = parentOf(x);
				} else {
					if (colorOf(leftOf(sib)) == BLACK) {
						setColor(rightOf(sib), BLACK);
						setColor(sib, RED);
						rotateLeft(sib);
						sib = leftOf(parentOf(x));
					}
					setColor(sib, colorOf(parentOf(x)));
					setColor(parentOf(x), BLACK);
					rotateRight(parentOf(x));
					x = root;
				}
			}
		}
		setColor(x, BLACK);
	}

	// get the node by the value
	private Node getNode(T ele) {
		Node p = root;
		while (p != null) {
			@SuppressWarnings("unchecked")
			int cmp = ele.compareTo(p.data);
			if (cmp > 0)
				p = p.right;
			else if (cmp < 0)
				p = p.left;
			else
				return p;
		}
		return null;
	}

	// ������������ת
	private void rotateRight(Node p) {
		if (p != null) {
			Node l = p.left;
			Node q = l.right;

			p.left = q;
			if (q != null) {
				q.parent = p;
			}
			l.parent = p.parent;
			if (p.parent == null) {
				root = l;
			} else if (p.parent.left == p) {
				p.parent.left = l;
			} else {
				p.parent.right = l;
			}
			l.right = p;
			p.parent = l;
		}
	}

	// ������������ת
	private void rotateLeft(Node p) {
		if (p != null) {
			Node r = p.right;
			Node q = r.left;
			// r �����Ӻ� p ��ָ
			p.right = q;
			if (q != null) {
				q.parent = p;
			}
			r.parent = p.parent;
			if (p.parent == null) {
				root = r;
			} else if (p.parent.left == p) {
				p.parent.left = r;
			} else {
				p.parent.right = r;
			}
			// r p ��ָ
			r.left = p;
			p.parent = r;
		}
	}

	private Node leftOf(Node x) {
		return (x == null ? null : x.left);
	}

	private Node rightOf(Node x) {
		return (x == null ? null : x.right);
	}

	private Node parentOf(Node x) {
		return (x == null ? null : x.parent);
	}

	private boolean colorOf(Node x) {
		return (x == null ? BLACK : x.color);
	}

	private void setColor(Node p, boolean c) {
		if (p != null) {
			p.color = c;
		}
	}
}
