package DataStructure.Tree;

/**
 * �������������
 * @author JohnnyLiao
 * @date 2015��7��2�� ����5:40:36
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
		
		tree.remove(20);
		tree.add(20);
		
		System.out.println("������ȱ����鿴��");
		System.out.println(tree.breadthFirst());
		tree.remove(30);
		System.out.println(tree.breadthFirst());
		
	/*	System.out.println("��������鿴��");
		System.out.println(tree.inIterator());

		System.out.println("+++" + tree.breadthFirst());
		tree.add(20);
		System.out.println("+++" + tree.breadthFirst());

		
		///// �Ƴ����������ʱ�����=====================
		System.out.println("remove");
		System.out.println(tree.inIterator());
		System.out.println(tree.breadthFirst() + "+++");
		tree.remove(10);
		System.out.println(tree.breadthFirst() + "+++");
		System.out.println(tree.inIterator());*/
		
	}
}
