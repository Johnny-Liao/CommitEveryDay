package DataStructure.Tree;

import java.util.List;

import DataStructure.Tree.ThreeLinkBinTree.TreeNode;

public class ThreeLinkBinTreeTest {

	public static void main(String[] args) {
		ThreeLinkBinTree<String> tbt = new ThreeLinkBinTree<>("root");
		
		TreeNode node1 = tbt.addNode(tbt.root(), "root.left", true);
		TreeNode node2 = tbt.addNode(tbt.root(), "root.right", false);
		TreeNode node3 = tbt.addNode(node1, "root.left.left", true);
		TreeNode node4 = tbt.addNode(node1, "root.left.right", false);
		TreeNode node5 = tbt.addNode(node4, "root.left.right.left", true);
		TreeNode node6 = tbt.addNode(node4, "root.left.right.right", false);
		
		List<TreeNode> preIter = tbt.preIterator();
		System.out.println("前序遍历");
		for (TreeNode t : preIter) {
			System.out.println(t);
		}
		
		List<TreeNode> inIter = tbt.inIterator();
		System.out.println("中序遍历");
		for (TreeNode t : inIter) {
			System.out.println(t);
		}
		
		List<TreeNode> postIter = tbt.postIterator();
		System.out.println("后序遍历");
		for (TreeNode t : postIter) {
			System.out.println(t);
		}
		
		List<TreeNode> breathFirst = tbt.breathFirst();
		System.out.println("层次遍历");
		for (TreeNode t : breathFirst) {
			System.out.println(t);
		}
		
		System.out.println("\n");
		
		System.out.println("root.left.right.rightChild():" + tbt.rightChild(node4));
		System.out.println("root.left.right.leftChild():" + tbt.leftChild(node4));
		System.out.println("root.left.right.parent():" + tbt.parent(node4));
		System.out.println("is empty? " + tbt.empty());
		System.out.println("root:" + tbt.root());
		
	}
}
