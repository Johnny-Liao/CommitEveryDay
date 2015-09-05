package Algorithm.Node;

/**
 * Definition of ListNode.
 * Created by johnny on 15-9-5.
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.value = val;
        this.next = next;
    }


    // ���߷�������������������������нڵ��ֵ
    public String listAllNodeValue() {
        ListNode head = this;
        StringBuilder result = new StringBuilder();
        result.append(value);
        while (head.next != null) {
            result.append("->" + head.next.value);
            head = head.next;
        }
        return result.toString();
    }
}
