package Algorithm.OtherButImportantToo;

import Algorithm.Node.ListNode;

/**
 * ʵ������ķ�ת��
 * ����������
 * ����ת������һ�������һ����k�����磬����Ϊ1��2��3��4��5��6��k=2����ת��2��1��6��5��4��3��
 * ��k=3����ת��3��2��1��6��5��4����k=4����ת��4��3��2��1��6��5���ó���ʵ�֡�
 *
 * ˼·��
 * ʹ�÷�ת�����˼·���������ǰ���ַ�ת��Ȼ������ĺ󲿷ַ�ת�����ǰ���������β�ڵ�ָ��󲿷������ͷ�ڵ㡣
 *
 * Created by johnny on 15-9-5.
 */
public class RotateLinkList {

    // ʹ�÷�ת�����˼·���������ǰ���ַ�ת��Ȼ������ĺ󲿷ַ�ת�����ǰ���������β�ڵ�ָ��󲿷������ͷ�ڵ㡣
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
     * ����������start(inclusive)���յ�end(exclusive)�Ľڵ㷴ת
     *
     * @param start ��������(����)
     * @param end   ������յ�(������)
     * @return ��ת�������ͷ�ڵ�
     */
    private static ListNode rotateList(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = cur.next;

        // ˼·�����ϵİѵ�һ���ڵ�ĺ���Ľڵ�ŵ���һ��λ���ϴӶ�ʵ������
        // �磺 1->2->3->4  ===   2->1->3->4    ==== 3->2->1->4   === 4->3->2->1
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
        ListNode afterRotate = rll.roteteLinkList(node1, 2); // ע�������ת֮��Ľڵ�
        System.out.println("After Rotate: " + afterRotate.listAllNodeValue());

/*      // ���������ֶ�������
        RotateLinkList rll = new RotateLinkList();
        ListNode rotate = rll.rotateList(node1, null);
        System.out.println(rotate.listAllNodeValue());
*/

    }
}
