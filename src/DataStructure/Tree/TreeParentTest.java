package DataStructure.Tree;

import java.util.List;

// ����TreeParent�Ĺ���
public class TreeParentTest {
	
	public static void main(String[] args) {
		TreeParent<String> tp = new TreeParent<String>("root");
		TreeParent.Node<String> root = tp.root();
		System.out.println(root);
		
		tp.addNode("�ڵ�1", root);
		System.out.println("��ȣ�" + tp.deep());
		
		tp.addNode("�ڵ�2", root);
		
		List<TreeParent.Node<String>> nodes = tp.children(root);
		System.out.println("���root�������ӽڵ㣺");
		for (TreeParent.Node<String> node : nodes) {
			System.out.println(node);
		}
		
		// ��root�ڵ�ĵ�һ���ӽڵ����ӽڵ�
		tp.addNode("�ڵ�3", nodes.get(0));
		
		System.out.println("��ȣ�" + tp.deep());
	}
}
