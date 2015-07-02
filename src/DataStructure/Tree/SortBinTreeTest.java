package DataStructure.Tree;

/**
 * 测试排序二叉树
 * @author JohnnyLiao
 * @date 2015年7月2日 下午5:40:36
 */
public class SortBinTreeTest {

	public static void main(String[] args) {
		SortBinTree<Integer> tree = new SortBinTree<>();
		tree.add(5);
		tree.add(20);
		tree.add(10);
		tree.add(3);
		tree.add(8);
		tree.add(15);
		tree.add(30);
		
/*		tree.remove(20);
		tree.add(20);*/
		
		System.out.println("广度优先遍历查看：");
		System.out.println(tree.breadthFirst());
		tree.remove(20);
		System.out.println(tree.breadthFirst());
		
	/*	System.out.println("中序遍历查看：");
		System.out.println(tree.inIterator());

		System.out.println("+++" + tree.breadthFirst());
		tree.add(20);
		System.out.println("+++" + tree.breadthFirst());

		
		///// 移除后三种情况时会出错=====================
		System.out.println("remove");
		System.out.println(tree.inIterator());
		System.out.println(tree.breadthFirst() + "+++");
		tree.remove(10);
		System.out.println(tree.breadthFirst() + "+++");
		System.out.println(tree.inIterator());*/
		
	}
}
