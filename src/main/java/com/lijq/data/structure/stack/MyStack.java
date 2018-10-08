package com.lijq.data.structure.stack;

import com.lijq.data.structure.list.ListNode;

/**
 * @author Lijq
 */
public class MyStack {

    public ListNode stackTop;
    public ListNode stackBottom;

    public MyStack(ListNode stackTop, ListNode stackBottom) {
        this.stackTop = stackTop;
        this.stackBottom = stackBottom;
    }

    /**
     * 进栈
     *
     * @param myStack 栈
     * @param value   值
     */
    public static void pushStack(MyStack myStack, int value) {

        ListNode node = new ListNode(value);

        // 头节点插入指针
        node.next = myStack.stackTop;
        myStack.stackTop = node;
    }

    /**
     * 遍历
     * 栈顶元素指针不指向栈底
     */
    public static void traverse(MyStack myStack) {
        ListNode stackTop = myStack.stackTop;
        while (stackTop != myStack.stackBottom) {
            System.out.print(stackTop.value + " ");
            stackTop = stackTop.next;
        }
    }

    /**
     * 判断是否为空
     */
    public static boolean isEmpty(MyStack myStack) {
        return myStack.stackTop == myStack.stackBottom;
    }

    /**
     * 出栈
     */
    public static void popStack(MyStack myStack) {
        // 栈不为空才出栈
        if (!isEmpty(myStack)) {
            ListNode stackTop = myStack.stackTop;
            myStack.stackTop = stackTop.next;
            System.out.println(stackTop.value);
        }
    }

    /**
     * 清空栈
     */
    public static void clearStack(MyStack myStack) {
        myStack.stackTop = null;
        myStack.stackBottom = myStack.stackTop;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(new ListNode(0), new ListNode(0));
        myStack.stackBottom = myStack.stackTop;

        System.out.println(isEmpty(myStack));

        pushStack(myStack, 1);
        pushStack(myStack, 2);
        pushStack(myStack, 3);
        traverse(myStack);

        System.out.println(isEmpty(myStack));

        popStack(myStack);
        clearStack(myStack);

        System.out.println(isEmpty(myStack));

    }
}
