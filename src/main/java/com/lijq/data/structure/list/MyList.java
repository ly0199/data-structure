package com.lijq.data.structure.list;

/**
 * @author Lijq
 */
public class MyList {

    /**
     * 插头法
     *
     * @param head    头结点
     * @param newHead 新元素
     */
    public static void headInsert(ListNode head, ListNode newHead) {
        ListNode old = head;
        head = newHead;
        head.next = old;
    }


    /**
     * 尾节点的插入
     *
     * @param tail    尾节点
     * @param newTail 新元素
     */
    public static void tailInsert(ListNode tail, ListNode newTail) {
        // tail.next = newTail; ??
        ListNode old = tail;
        tail = newTail;
        tail.next = null;
        old.next = tail;
    }

    /**
     * 遍历
     *
     * @param head 头节点
     */
    public static void traverse(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 查找
     *
     * @param head  头节点
     * @param value 值
     * @return int
     */
    public static int find(ListNode head, int value) {
        int index = -1;
        int count = 0;
        while (head != null) {
            if (head.value == value) {
                index = count;
            }
            count++;
            head = head.next;
        }
        return index;
    }

    /**
     * 插入操作
     *
     * @param p 节点
     * @param s 新增节点
     */
    public static void insert(ListNode p, ListNode s) {
        ListNode next = p.next;
        p.next = s;
        s.next = next;
    }

    /**
     * 删除
     *
     * @param head 头节点
     * @param q    删除节点
     */
    public static void delete(ListNode head, ListNode q) {

        // 如果节点不为空，并且节点的下一个节点也不为空，即不是最后一个节点
        // 那么将后一个节点的值和next都赋值给删除节点，然后将后一个节点置为null即可变相的实现删除操作
        if (q != null && q.next != null) {
            ListNode p = q.next;
            q.value = p.value;
            // 删除q.next
            q.next = p.next;
            p = null;
        }

        // 删除最后一个节点的情况
        if (q != null && q.next == null) {
            while (head != null) {
                if (head.next != null && head.next == q) {
                    head.next = null;
                    break;
                }
                head = head.next;
            }
        }
    }


    public static void main(String[] args) {

        // 定义
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        // 遍历
        traverse(node1);

        // 头插入
        ListNode newHead = new ListNode(0);
        headInsert(node1, newHead);
        traverse(newHead);

        // 尾插入
        ListNode newTail = new ListNode(4);
        tailInsert(node3, newTail);
        traverse(newHead);

        // 查找
        System.out.println(find(newHead, 3));

        // 普通插入
        ListNode node = new ListNode(5);
        insert(node3, node);
        traverse(newHead);

        // 删除
        delete(newHead, node3);
        traverse(newHead);
    }
}
