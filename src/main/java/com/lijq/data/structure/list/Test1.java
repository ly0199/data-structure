package com.lijq.data.structure.list;

/**
 * @author Lijq
 */
public class Test1 {

    /**
     * 反转链表
     * 时间复杂度 O(n) 空间复杂度 O(1）
     */
    public static ListNode reverseList(ListNode head) {

        // 当前节点的上一个节点
        ListNode pre = null;
        // 当前节点的下一个节点
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 取中间的节点
     * 偶数时取中间节点的前面那个
     */
    public static ListNode getMid(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        // fast 快指针每次走2步，slow 慢指针每次走1步
        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        // 定义
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        // 取中间节点
        System.out.println(getMid(node1).value);

        // 单链表反转
        ListNode listNode = reverseList(node1);
        while (listNode != null) {
            System.out.print(listNode.value + " ");
            listNode = listNode.next;
        }

    }
}
