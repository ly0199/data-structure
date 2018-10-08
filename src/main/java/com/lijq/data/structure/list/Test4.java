package com.lijq.data.structure.list;

/**
 * 归并排序(MERGE-SORT)是利用归并的思想实现的排序方法
 * 该算法采用经典的分治策略（分治法将问题分成一些小的问题，然后递归求解，
 * 而治的阶段则将分的阶段得到的各答案“修补”在一起，即分而治之）
 *
 * @author Lijq
 */
public class Test4 {

    /**
     * 归并排序的一般步骤
     * 1. 将待排序的数组（链表）取中点并一分为二
     * 2. 递归的对左半部分进行归并排序
     * 3. 递归的对右半部分进行归并排序
     * 4. 将2个部分进行合并，得到结果
     * <p>
     * 首先用快慢指针（快指针一次走2步，慢指针一次走1步，快指针在链表末尾时，慢指针在链表中间）
     * 找到链表的中间节点，然后递归的对2个子链表进行排序，把两个排好序的子链表合并成一个有序的链表
     */

    public ListNode meger(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }

        ListNode head = head1.value < head2.value ? head1 : head2;
        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head2 ? head2 : head1;

        // cur1 的上一个节点
        ListNode pre = null;
        // cur2 的下一个节点
        ListNode next = null;

        if (cur1 != null && cur2 != null) {
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

    public ListNode getMid(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);

        ListNode right = mid.next;

        // 咬断链表
        mid.next = null;

        ListNode node = meger(sortList(head), sortList(right));
        return node;
    }
}
