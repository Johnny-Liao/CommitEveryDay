package DataStructure.Tree;

import java.util.List;

// ����TreeChild�Ĺ���
public class TreeChildTest {
	public static void main(String[] args) {
		TreeChild<String> tc = new TreeChild<String>("root");
		TreeChild.Node<String> root = tc.root();
		System.out.println("���ڵ㣺" + root);
		
		tc.addNode("�ڵ�1", root);
		tc.addNode("�ڵ�2", root);
		tc.addNode("�ڵ�3", root);
		
		System.out.println("����ӽڵ��ĸ��ڵ㣺" + root);
		System.out.println("��ȣ�" + tc.deep());		// 2

		List<TreeChild.Node<String>> childs = tc.children(root);
		for (TreeChild.Node<String> child : childs) {
			System.out.println(child);
		}
		
		// Ϊ��һ���ӽڵ���ӽڵ�
		tc.addNode("�ڵ�4", childs.get(0));
		
		System.out.println("��ȣ�" + tc.deep());
	}
}
