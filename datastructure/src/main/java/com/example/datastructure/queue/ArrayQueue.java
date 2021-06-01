package com.example.datastructure.queue;

/**
 * 队列是一个有序列表,可以用 数组（顺序存储） 或 链表实现（链式存储）
 * 原则：先入先出
 */
class ArrayQueue {
    private final int maxSize;//数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private final int[] arr;//该数组用于存放数据

    //构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头的前一个位置
        rear = -1; //指向队列尾（即就是队列最后一个数据）
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满！");
        } else {
            rear++;
            arr[rear] = n;
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空！");
        } else {
            front++;
            return arr[front];
        }
    }

    // 显示队列数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空！");
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空！");
        } else {
            return arr[front + 1];
        }
    }

}
