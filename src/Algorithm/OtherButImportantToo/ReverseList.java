package Algorithm.OtherButImportantToo;

import Algorithm.Node.ListNode;

/**
 * 反转单链表
 * Created by johnny on 15-10-14.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode result_head = null;
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;

            if (next == null)
                result_head = current;

            current.next = prev;    // 当前节点指向前一个节点

            // 节点后移
            prev = current;
            current = next;
        }
        return result_head;
    }



    // Just test
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println("Before Rotate: " + node1.listAllNodeValue());
        ReverseList rl = new ReverseList();
        ListNode afterRotate = rl.reverseList(node1); // 注意输出反转之后的节点
        System.out.println("After Rotate: " + afterRotate.listAllNodeValue());

    }

}
