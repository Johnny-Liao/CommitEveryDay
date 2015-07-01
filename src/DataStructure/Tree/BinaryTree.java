package DataStructure.Tree;

class TreeNode {
	private int key = 0;
	private String data = null;
	private boolean isVisted = false;
	private TreeNode leftChild = null;
	private TreeNode rightChild = null;

	public TreeNode() {
	}

	public TreeNode(int key, String data) {
		this.key = key;
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public boolean isVisted() {
		return isVisted;
	}

	public void setVisted(boolean isVisted) {
		this.isVisted = isVisted;
	}
}

/**
 * ����������һ��ʵ�ַ�ʽ��������ҳ�ϴ��룬�ڴ�����ԭַ��
 * <tt>http://blog.sina.cn/dpool/blog/s/blog_4de067e40100leb8.html</tt>
 * ��ݴ���ܺõ���ʾ�˶���������ĵݹ����Լ�����ʹ�õݹ�����������������⣬���Ժܺõ�ѧϰ�ݹ顣
 * 
 * @author ����һ����
 */
public class BinaryTree {
	private TreeNode root = null;

	public BinaryTree() {
		root = new TreeNode(1, "rootNode(A)");
	}

	public void createBinTree(TreeNode root) {
		// �ֶ��Ĵ������ṹ��ͼ��ʾ��
		TreeNode newNodeB = new TreeNode(2, "B");
		TreeNode newNodeC = new TreeNode(3, "C");
		TreeNode newNodeD = new TreeNode(4, "D");
		TreeNode newNodeE = new TreeNode(5, "E");
		TreeNode newNodeF = new TreeNode(6, "F");
		root.setLeftChild(newNodeB);
		root.setRightChild(newNodeC);
		root.getLeftChild().setLeftChild(newNodeD);
		root.getLeftChild().setRightChild(newNodeE);
		root.getRightChild().setRightChild(newNodeF);
	}

	public boolean IsEmpty() {
		// �ж������շ�
		return root == null;
	}

	public int Height() {
		// �����߶�
		return Height(root);
	}

	public int Height(TreeNode subTree) {
		if (subTree == null)
			return 0; // �ݹ�����������߶�Ϊ0
		else {
			int i = Height(subTree.getLeftChild());
			int j = Height(subTree.getRightChild());
			return (i < j) ? j + 1 : i + 1;
		}
	}

	public int intSize() {
		// ������
		return Size(root);
	}

	public int Size(TreeNode subTree) {
		if (subTree == null)
			return 0;
		else {
			return 1 + Size(subTree.getLeftChild()) + Size(subTree.getRightChild());
		}
	}

	public TreeNode Parent(TreeNode element) {
		// ����˫�׽��
		return (root == null || root == element) ? null : Parent(root, element);
	}

	public TreeNode Parent(TreeNode subTree, TreeNode element) {
		if (subTree == null)
			return null;
		if (subTree.getLeftChild() == element || subTree.getRightChild() == element)
			// �ҵ�, ���ظ�����ַ
			return subTree;
		TreeNode p;
		// �������������ң������������û���ҵ����ŵ�������ȥ��
		if ((p = Parent(subTree.getLeftChild(), element)) != null)
			// �ݹ���������������
			return p;
		else
			// �ݹ���������������
			return Parent(subTree.getRightChild(), element);
	}

	public TreeNode LeftChild(TreeNode element) {
		// ����������
		return (element != null) ? element.getLeftChild() : null;
	}

	public TreeNode RightChild(TreeNode element) {
		// ����������
		return (element != null) ? element.getRightChild() : null;
	}

	public TreeNode getRoot() {
		// ȡ�ø����
		return root;
	}

	public void destroy(TreeNode subTree) {
		// ˽�к���: ɾ����ΪsubTree������
		if (subTree != null) {
			destroy(subTree.getLeftChild()); // ɾ��������
			destroy(subTree.getRightChild()); // ɾ��������
			// delete subTree; //ɾ�������
			subTree = null;
		}
	}

	public void Traverse(TreeNode subTree) {
		System.out.println("key:" + subTree.getKey() + "--name:" + subTree.getData());
		Traverse(subTree.getLeftChild());
		Traverse(subTree.getRightChild());
	}

	public void PreOrder(TreeNode subTree) {
		// �ȸ�
		if (subTree != null) {
			visted(subTree);
			PreOrder(subTree.getLeftChild());
			PreOrder(subTree.getRightChild());
		}
	}

	public void InOrder(TreeNode subTree) {
		// �и�
		if (subTree != null) {
			InOrder(subTree.getLeftChild());
			visted(subTree);
			InOrder(subTree.getRightChild());
		}
	}

	public void PostOrder(TreeNode subTree) {
		// ���
		if (subTree != null) {
			PostOrder(subTree.getLeftChild());
			PostOrder(subTree.getRightChild());
			visted(subTree);
		}
	}

	public void LevelOrder(TreeNode subTree) {
		// ˮƽ���
	}

	public boolean Insert(TreeNode element) {
		// ����
		return true;
	}

	public boolean Find(TreeNode element) {
		// ����
		return true;
	}

	public void visted(TreeNode subTree) {
		subTree.setVisted(true);
		System.out.println("key:" + subTree.getKey() + "--name:" + subTree.getData());
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinTree(bt.root);
		System.out.println("the size of the tree is " + bt.intSize());
		System.out.println("the height of the tree is " + bt.Height());
		System.out.println("*******�ȸ�(ǰ��)[ABDECF]����*****************");
		bt.PreOrder(bt.root);
		System.out.println("*******�и�(����)[DBEACF]����*****************");
		bt.InOrder(bt.root);
		System.out.println("*******���(����)[DEBFCA]����*****************");
		bt.PostOrder(bt.root);
	}
}
