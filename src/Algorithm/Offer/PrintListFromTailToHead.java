package Algorithm.Offer;

import Algorithm.Node.ListNode;

import java.util.ArrayList;

/**
 * ��β��ͷ��ӡ����
 * Created by johnny on 15-10-11.
 */
public class PrintListFromTailToHead {
    static ArrayList<Integer> listVal = new ArrayList<>();

    // ��β��ͷ��ӡ����--���ı�����ṹ
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null)
            return listVal;
        if (listNode != null) {
            if (listNode.next != null) {
                printListFromTailToHead(listNode.next);
            }
            listVal.add(listNode.value);
        }
        return listVal;
    }



    // ����������ݲ�����
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println("Before : " + node1.listAllNodeValue());

        ArrayList<Integer> back = printListFromTailToHead(node1);
        for(Integer integer : back) {
            System.out.println(integer);
        }
    }
}
