package Algorithm.OtherButImportantToo;

import Algorithm.Node.ListNode;

/**
 * 实现链表的反转：
 * 问题描述：
 * 链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，
 * 若k=3，翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
 *
 * 思路：
 * 使用反转链表的思路，将链表的前部分反转，然后将链表的后部分反转，最后将前部分链表的尾节点指向后部分链表的头节点。
 *
 * Created by johnny on 15-9-5.
 */
public class RotateLinkList {

    // 使用反转链表的思路，将链表的前部分反转，然后将链表的后部分反转，最后将前部分链表的尾节点指向后部分链表的头节点。
    public static ListNode roteteLinkList(ListNode head, int n) {
        ListNode leftEnd = head;
        int i = 0;
        while (i++ < n) {
            leftEnd = leftEnd.next;
        }
        ListNode leftRotate = rotateList(head, leftEnd);        // rotate left
        ListNode rightRotate = rotateList(leftEnd, null);       // rotate right
        head.next = rightRotate;        // join the right after left. notice: head is end of the left now.
        return leftRotate;
    }

    /**
     * 将链表从起点start(inclusive)到终点end(exclusive)的节点反转
     *
     * @param start 链表的起点(包括)
     * @param end   链表的终点(不包括)--这个场景需要，直接反转单链表为null
     * @return 反转后链表的头节点
     */
    private static ListNode rotateList(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;

        // 思路：不断的把后面的节点指向前面一个，最后输出尾节点。
        // 如： 1<-2 3->4  ===   1<-2<-3 4    ==== 1<-2<-3<-4
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println("Before Rotate: " + node1.listAllNodeValue());
        RotateLinkList rll = new RotateLinkList();
        ListNode afterRotate = rll.roteteLinkList(node1, 2); // 注意输出反转之后的节点
        System.out.println("After Rotate: " + afterRotate.listAllNodeValue());

/*      // 上下两部分独立测试
        RotateLinkList rll = new RotateLinkList();
        ListNode rotate = rll.rotateList(node1, null);
        System.out.println(rotate.listAllNodeValue());
*/

    }
}
