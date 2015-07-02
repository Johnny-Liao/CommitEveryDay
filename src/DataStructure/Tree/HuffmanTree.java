package DataStructure.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author JohnnyLiao
 * @date 2015年7月2日 下午2:04:35
 */
public class HuffmanTree {

	/**
	 * Node节点 - 增加权重值
	 * @author JohnnyLiao
	 * @date 2015年7月2日 下午2:07:11
	 * @param <E>
	 *            Node类型
	 */
	public static class Node<E> {
		E data;
		double weight;
		Node<E> left;
		Node<E> right;

		public Node(E data, double weight) {
			this.data = data;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node[data=" + data + ", weight=" + weight + "]";
		}
	}

	/**
	 * 构造哈夫曼树
	 * 
	 * @param nodes
	 *            节点集合
	 * @return 构造出的哈夫曼树的根节点
	 */
	private static <E> Node<E> creatHuffmanTree(List<Node<E>> nodes) {
		// 只要nodes数组中还有两个以上节点--构造过程
		while (nodes.size() > 1) {
			quickSort(nodes);
			// 获取最小的两个节点
			Node<E> left = nodes.get(nodes.size() - 1);
			Node<E> right = nodes.get(nodes.size() - 2);

			// 生成新节点
			Node<E> parent = new Node<>(null, left.weight + right.weight);
			parent.left = left;
			parent.right = right;

			// 删除权值最小的两个节点
			nodes.remove(nodes.size() - 1);
			nodes.remove(nodes.size() - 1);
			
			// 将新生成的父节点添加到集合
			nodes.add(parent);
		}
		// 最后返回nodes集合中唯一一个节点，也就是根节点
		return nodes.get(0);
	}

	/**
	 * 快速排序
	 * 
	 * @param nodes
	 *            传入的nodes集合
	 */
	private static <E> void quickSort(List<Node<E>> nodes) {
		subSort(nodes, 0, nodes.size() - 1);
	}

	private static <E> void subSort(List<Node<E>> nodes, int start, int end) {
		if (start < end) {
			// get the first one
			Node<E> base = nodes.get(start);
			int i = start;
			int j = end + 1;
			while (true) {
				while (i < end && nodes.get(++i).weight >= base.weight)
					; // 逆序
				while (j > start && nodes.get(--j).weight <= base.weight)
					;
				if (i < j) {
					swap(nodes, i, j);
				} else {
					break;
				}
			}
			swap(nodes, start, j);

			// recursive
			subSort(nodes, start, j - 1);
			subSort(nodes, j + 1, end);
		}
	}

	// 用于交换集合内的元素
	private static <E> void swap(List<Node<E>> nodes, int i, int j) {
		Node<E> tmp = nodes.get(i);
		nodes.set(i, nodes.get(j));
		nodes.set(j, tmp);
	}
	
	/**
	 * 广度优先遍历
	 * @param root 传入根节点
	 * @return 排好序的Node集合
	 */
	public static <E> List<Node<E>> breadthFirst(Node<E> root) {
		List<Node<E>> list = new ArrayList<Node<E>>();
		// 借助FIFO的队列来实现
		Queue<Node<E>> queue = new ArrayDeque<Node<E>>();			// deque:double-ended queue 双端队列
		if (root != null) {
			queue.offer(root);
		}
		
		while (!queue.isEmpty()) {
			// 将队列的头部元素添加到list中
			list.add(queue.peek());
			// 将该队列的“头部”元素移出队列
			Node<E> p = queue.poll();
			// 如果左子节点不为空，将它加入队列
			if (p.left != null) {
				queue.offer(p.left);
			}
			// 如果右子节点不为空，将它加入队列
			if (p.right != null) {
				queue.offer(p.right);
			}
		}
		return list;
	}
	
	// 测试
	public static void main(String[] args) {
		List<Node<String>> nodes = new ArrayList<>();
		nodes.add(new Node<String>("A", 40.0));
		nodes.add(new Node<String>("B", 7.0));
		nodes.add(new Node<String>("C", 10.0));
		nodes.add(new Node<String>("D", 30.0));
		nodes.add(new Node<String>("E", 12.0));
		nodes.add(new Node<String>("F", 2.0));
		
		Node<String> root = HuffmanTree.creatHuffmanTree(nodes);
		System.out.println(breadthFirst(root));
		// 格式化输出-生成的data=null的父节点不给予显示
		List<Node<String>> iter = breadthFirst(root);
		for (Node<String> it : iter) {
			if (it.data != null) 
				System.out.println(it);
		}
	}
}
