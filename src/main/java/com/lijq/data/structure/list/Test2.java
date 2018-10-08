package com.lijq.data.structure.list;

/**
 * 合并2个有序链表
 *
 * @author Lijq
 */
public class Test2 {


    /**
     * 采用递归
     */
    public static ListNode megerTwoList(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode head = null;

        // 递归
        if (head1.value > head2.value) {
            head = head2;
            head.next = megerTwoList(head1, head2.next);
        } else {
            head = head1;
            head.next = megerTwoList(head1.next, head2);
        }
        return head;
    }

    /**
     * 采用非递归
     */
    public static ListNode megerTwoList2(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        ListNode head = head1.value < head2.value ? head1 : head2;
        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head1 ? head2 : head1;

        // cur1前一个元素
        ListNode pre = null;
        // cur2后一个元素
        ListNode next = null;

        while (cur1 != null && cur2 != null) {

            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }

        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public static void main(String[] args) {
        // 定义
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node3;
        node2.next = node4;

        ListNode listNode = megerTwoList2(node1, node2);
        while (listNode != null) {
            System.out.print(listNode.value + " ");
            listNode = listNode.next;
        }
    }

}
