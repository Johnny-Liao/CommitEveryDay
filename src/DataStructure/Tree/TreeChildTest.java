package DataStructure.Tree;

import java.util.List;

import DataStructure.Tree.TreeChild.Node;

// ����TreeChild�Ĺ���---��סfirst��ָ��һ���ӽڵ��λ�ã������������е�λ�ã�
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
		
		System.out.println("�ڵ�1����ӽڵ�ǰ��" + childs.get(0));
		// Ϊ��һ���ӽڵ���ӽڵ�
		tc.addNode("�ڵ�4", childs.get(0));
		
		System.out.println("�ڵ�1����ӽڵ��" + tc.getChildForIndex(root, 0));

		System.out.println("��ȣ�" + tc.deep());
		System.out.println(tc.getChildForIndex(root, 2));
		
		Node<String> node4 = tc.getChildForIndex(childs.get(0), 0);
		System.out.println(node4);
		
		System.out.println("�ڵ�4�ĸ��ڵ㣺" + tc.parent(node4));
		
		
		tc.addNode("�ڵ�5", node4);
		Node<String> node5 = tc.getChildForIndex(node4, 0);
		System.out.println(node5);
		System.out.println("�ڵ�5�ĸ��ڵ㣺" + tc.parent(node5));
		
		System.out.println("root�ĸ��ڵ㣺" + tc.parent(root));
		
		
	}
}
