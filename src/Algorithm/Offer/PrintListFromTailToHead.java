package Algorithm.Offer;

import Algorithm.Node.ListNode;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * Created by johnny on 15-10-11.
 */
public class PrintListFromTailToHead {

    static ArrayList<Integer> listVal = new ArrayList<>();

    // 从尾到头打印链表--不改变链表结构
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            if (listNode.next != null) {
                printListFromTailToHead(listNode.next);
            }
            listVal.add(listNode.value);
        }
        return listVal;
    }



    // 构造测试数据并测试
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
