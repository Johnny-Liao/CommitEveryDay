package DataStructure.Tree;

public class TwoLinkBinTreeTest {

	public static void main(String[] args) {
		TwoLinkBinTree<String> binTree = new TwoLinkBinTree<>("���ڵ�");
		
		TwoLinkBinTree.TreeNode tn1 = binTree.addNode(binTree.root(), "�ڶ�����ڵ�", true); 
		TwoLinkBinTree.TreeNode tn2 = binTree.addNode(binTree.root(), "�ڶ����ҽڵ�", false); 
		TwoLinkBinTree.TreeNode tn3 = binTree.addNode(tn1, "��������ڵ�", true); 
		TwoLinkBinTree.TreeNode tn4 = binTree.addNode(tn2, "�������ҽڵ�", false); 
		TwoLinkBinTree.TreeNode tn5 = binTree.addNode(tn3, "���Ĳ���ڵ�", true);
		
		System.out.println("tn2's left child " + binTree.leftChild(tn2));
		System.out.println("tn2's right child " + binTree.rightChild(tn2));
		System.out.println("deep: " + binTree.deep());
		
/*		System.out.println("tn5's parent: " + binTree.parent(tn5));
		System.out.println("tn5's parent: " + binTree.parent(tn3));*/
		
		System.out.println("root:" + binTree.root());
		System.out.println("binTree is empty?" + binTree.empty());
		
		TwoLinkBinTree<String> binTree2 = new TwoLinkBinTree<>();
		System.out.println("binTree2 is empty?" + binTree2.empty());
	}

}
