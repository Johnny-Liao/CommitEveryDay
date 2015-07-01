package DataStructure.Tree;

// 二叉树的顺序存储方式实现--测试
public class ArrayBinTreeTest {

	public static void main(String[] args) {
		ArrayBinTree<String> binTree = new ArrayBinTree<>(4, "root");
		
		binTree.add(0, "第二层右子节点", false);
		binTree.add(2, "第三层右子节点", false);
		binTree.add(6, "第四层右子节点", false);
		
		System.out.println(binTree);
		
		System.out.println(binTree.root());
		
		System.out.println("6号索引的右节点：" + binTree.right(6));	// 6 = 4 + 2
		
		System.out.println("6号索引的右节点所在位置：" + binTree.pos(binTree.right(6)));		// 8 + 4 + 2
		
		System.out.println("deep:" + binTree.deep());		// begin with 1
		
		System.out.println("14号索引的父节点：" + binTree.parent(14));
		
		System.out.println("empty:" + binTree.empty());
	}
}
