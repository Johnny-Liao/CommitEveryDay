package DataStructure.Tree;

// ��������˳��洢��ʽʵ��--����
public class ArrayBinTreeTest {

	public static void main(String[] args) {
		ArrayBinTree<String> binTree = new ArrayBinTree<>(4, "root");
		
		binTree.add(0, "�ڶ������ӽڵ�", false);
		binTree.add(2, "���������ӽڵ�", false);
		binTree.add(6, "���Ĳ����ӽڵ�", false);
		
		System.out.println(binTree);
		
		System.out.println(binTree.root());
		
		System.out.println("6���������ҽڵ㣺" + binTree.right(6));	// 6 = 4 + 2
		
		System.out.println("6���������ҽڵ�����λ�ã�" + binTree.pos(binTree.right(6)));		// 8 + 4 + 2
		
		System.out.println("deep:" + binTree.deep());		// begin with 1
		
		System.out.println("14�������ĸ��ڵ㣺" + binTree.parent(14));
		
		System.out.println("empty:" + binTree.empty());
	}
}
