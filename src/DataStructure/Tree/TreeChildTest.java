package DataStructure.Tree;

import java.util.List;

// 测试TreeChild的功能
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
		
		// 为第一个子节点添加节点
		tc.addNode("节点4", childs.get(0));
		
		System.out.println("深度：" + tc.deep());
	}
}
