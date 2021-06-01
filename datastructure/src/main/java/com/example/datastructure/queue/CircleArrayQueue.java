package com.example.datastructure.queue;

/**
 * 环形队列
 */
public class CircleArrayQueue {
    private final int maxSize;//数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private final int[] arr;//该数组用于存放数据

    //构造器
    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; // 指向队列头
        rear = 0; //指向队列尾
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
            arr[rear] = n;
            // 将rear后移，考虑取模
            rear = (rear + 1) % maxSize;
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空！");
        } else {
            // 因为此时front指向的时对头，如果直接返回，则不能使front++;如果先++，则取不出对头
            // 所以先用临时变量
            int head = arr[front];
            front = (front + 1) % maxSize;// 注意取模
            return head;
        }
    }

    // 显示队列数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空！");
        }

        // 从front 开始遍历
        for (int i = front; i < size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 环形队列中的有效数据
     */
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    // 显示队列头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空！");
        } else {
            return arr[front];
        }
    }
}
