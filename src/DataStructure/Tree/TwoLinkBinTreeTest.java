package DataStructure.Tree;

public class TwoLinkBinTreeTest {

	public static void main(String[] args) {
		TwoLinkBinTree<String> binTree = new TwoLinkBinTree<>("根节点");
		
		TwoLinkBinTree.TreeNode tn1 = binTree.addNode(binTree.root(), "第二层左节点", true); 
		TwoLinkBinTree.TreeNode tn2 = binTree.addNode(binTree.root(), "第二层右节点", false); 
		TwoLinkBinTree.TreeNode tn3 = binTree.addNode(tn1, "第三层左节点", true); 
		TwoLinkBinTree.TreeNode tn4 = binTree.addNode(tn2, "第三层右节点", false); 
		TwoLinkBinTree.TreeNode tn5 = binTree.addNode(tn3, "第四层左节点", true);
		
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
