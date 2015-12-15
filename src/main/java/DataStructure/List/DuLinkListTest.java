package DataStructure.List;

/**
 * Doubly-linked list test.
 * 
 * @author JohnnyLiao
 * @date 2015年7月12日 下午2:51:04
 */
public class DuLinkListTest {
	public static void main(String[] args) {
		DuLinkList<String> list = new DuLinkList<>();
		list.add("aaa");
		list.add("bbb");
		list.insert("ccc", 0);
		list.insert("ddd", 1);
		System.out.println(list);

		list.delete(2);
		System.out.println(list);
		System.out.println(list.reverseToString());

		System.out.println("ccc在线性表中的位置：" + list.locate("ccc"));
		System.out.println("链表中索引1处的元素：" + list.get(1));
		list.remove();
		System.out.println("After remove():" + list);
		list.delete(0);
		System.out.println("After delete(0):" + list);
	}
}
