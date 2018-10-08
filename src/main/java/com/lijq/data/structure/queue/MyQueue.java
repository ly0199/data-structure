package com.lijq.data.structure.queue;

/**
 * @author Lijq
 */
public class MyQueue {

    public int[] arrays;
    // 指向的是第一个有效元素
    public int front;
    // 指向的是最后一个有效元素的下一个元素（无效元素）
    public int rear;


    public MyQueue(int[] arrays, int front, int rear) {
        this.arrays = arrays;
        this.front = front;
        this.rear = rear;
    }

    /**
     * 判断是否满
     */
    public static boolean isFull(MyQueue myQueue) {
        return (myQueue.rear + 1) % myQueue.arrays.length == myQueue.front;
    }

    /**
     * 判断是否空
     */
    public static boolean isEmpty(MyQueue myQueue) {
        return myQueue.rear == myQueue.front;
    }

    /**
     * 入队
     */
    public static void enQueue(MyQueue myQueue, int value) {
        if (!isFull(myQueue)) {
            myQueue.arrays[myQueue.rear] = value;
            myQueue.rear = (myQueue.rear + 1) % myQueue.arrays.length;
        }
    }

    /**
     * 遍历
     */
    public static void traverse(MyQueue myQueue) {
        int i = myQueue.front;
        while (i != myQueue.rear) {
            System.out.print(myQueue.arrays[i] + " ");
            i = (i + 1) % myQueue.arrays.length;
        }
        System.out.println();
    }

    /**
     * 出队
     */
    public static void outQueue(MyQueue myQueue) {
        if (!isEmpty(myQueue)) {
            int value = myQueue.arrays[myQueue.front];
            System.out.println(value);
            myQueue.front = (myQueue.front + 1) % myQueue.arrays.length;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(new int[6], 0, 0);
        System.out.println(isEmpty(myQueue));

        enQueue(myQueue, 1);
        enQueue(myQueue, 2);
        enQueue(myQueue, 3);
        enQueue(myQueue, 4);
        enQueue(myQueue, 5);

        System.out.println(isFull(myQueue));

        traverse(myQueue);

        outQueue(myQueue);
    }
}
