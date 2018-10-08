package com.lijq.data.structure.queue;

import java.util.Stack;

/**
 * @author Lijq
 */
public class TwoStackOneQueue {


    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;


    public TwoStackOneQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public void add(int value) {
        stackPush.push(value);
    }

    /**
     * 获取到队首元素 并拿掉
     */
    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /**
     * 获取队首数据
     */
    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackOneQueue queue = new TwoStackOneQueue(new Stack<Integer>(), new Stack<Integer>());

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
