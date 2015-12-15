package DataStructure.Tree;

public class TwoLinkBinTreeTest {

	public static void main(String[] args) {
		TwoLinkBinTree<String> binTree = new TwoLinkBinTree<>("根节点");
		
		TwoLinkBinTree.TreeNode tn1 = binTree.addNode(binTree.root(), "root.left", true); 
		TwoLinkBinTree.TreeNode tn2 = binTree.addNode(binTree.root(), "root.right", false); 
		TwoLinkBinTree.TreeNode tn3 = binTree.addNode(tn1, "root.left.left", true); 
		TwoLinkBinTree.TreeNode tn4 = binTree.addNode(tn2, "root.right.right", false); 
		TwoLinkBinTree.TreeNode tn5 = binTree.addNode(tn3, "root.left.left.left", true);
		
		System.out.println("tn2's left child " + binTree.leftChild(tn2));
		System.out.println("tn2's right child " + binTree.rightChild(tn2));
		System.out.println("deep: " + binTree.deep());
		
		System.out.println("root:" + binTree.root());
		System.out.println("binTree is empty?" + binTree.empty());
		
		TwoLinkBinTree<String> binTree2 = new TwoLinkBinTree<>();
		System.out.println("binTree2 is empty?" + binTree2.empty());

		System.out.println("tn5's (root.left.left.left) parent: " + binTree.parent(tn5));
		System.out.println("tn3's (root.left.left) parent: " + binTree.parent(tn3));
		System.out.println("tn4's (root.right.right) parent: " + binTree.parent(tn4));
		System.out.println("tn2's (root.right) parent: " + binTree.parent(tn2));
//		System.out.println("根节点的父节点：（报错）" + binTree.parent(binTree.root()));
	}

}
