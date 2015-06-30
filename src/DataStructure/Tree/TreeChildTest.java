package DataStructure.Tree;

import java.util.List;

import DataStructure.Tree.TreeChild.Node;

// 测试TreeChild的功能---记住first是指第一个子节点的位置（在整个数组中的位置）
public class TreeChildTest {
	public static void main(String[] args) {
		TreeChild<String> tc = new TreeChild<String>("root");
		TreeChild.Node<String> root = tc.root();
		System.out.println("根节点：" + root);
		
		tc.addNode("节点1", root);
		tc.addNode("节点2", root);
		tc.addNode("节点3", root);
		
		System.out.println("添加子节点后的根节点：" + root);
		System.out.println("深度：" + tc.deep());		// 2

		List<TreeChild.Node<String>> childs = tc.children(root);
		for (TreeChild.Node<String> child : childs) {
			System.out.println(child);
		}
		
		System.out.println("节点1添加子节点前：" + childs.get(0));
		// 为第一个子节点添加节点
		tc.addNode("节点4", childs.get(0));
		
		System.out.println("节点1添加子节点后：" + tc.getChildForIndex(root, 0));

		System.out.println("深度：" + tc.deep());
		System.out.println(tc.getChildForIndex(root, 2));
		
		Node<String> node4 = tc.getChildForIndex(childs.get(0), 0);
		System.out.println(node4);
		
		System.out.println("节点4的父节点：" + tc.parent(node4));
		
		
		tc.addNode("节点5", node4);
		Node<String> node5 = tc.getChildForIndex(node4, 0);
		System.out.println(node5);
		System.out.println("节点5的父节点：" + tc.parent(node5));
		
		System.out.println("root的父节点：" + tc.parent(root));
		
		
	}
}
