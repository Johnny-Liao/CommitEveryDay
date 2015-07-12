package DataStructure.List;

/**
 * Doubly-linked list test.
 * 
 * @author JohnnyLiao
 * @date 2015��7��12�� ����2:51:04
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

		System.out.println("ccc�����Ա��е�λ�ã�" + list.locate("ccc"));
		System.out.println("����������1����Ԫ�أ�" + list.get(1));
		list.remove();
		System.out.println("After remove():" + list);
		list.delete(0);
		System.out.println("After delete(0):" + list);
	}
}
