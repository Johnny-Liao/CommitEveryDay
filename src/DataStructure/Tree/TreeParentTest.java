package DataStructure.Tree;

import java.util.List;

public class TreeParentTest {
	
	public static void main(String[] args) {
		TreeParent<String> tp = new TreeParent<String>("root");
		TreeParent.Node<String> root = tp.root();
		System.out.println(root);
		
		tp.addNode("节点1", root);
		System.out.println("深度：" + tp.deep());
		
		tp.addNode("节点2", root);
		
		List<TreeParent.Node<String>> nodes = tp.children(root);
		System.out.println("输出root的所有子节点：");
		for (TreeParent.Node<String> node : nodes) {
			System.out.println(node);
		}
		
		// 给root节点的第一个子节点增加节点
		tp.addNode("节点3", nodes.get(0));
		
		System.out.println("深度：" + tp.deep());
	}
}
