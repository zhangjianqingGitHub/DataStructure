package com.example.datastructure.queue;

/**
 * 使用数组模拟队列
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);

        int head = arrayQueue.headQueue();
        System.out.println(head);

        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        circleArrayQueue.addQueue(1);
        circleArrayQueue.addQueue(2);
        circleArrayQueue.addQueue(3);

        int head2 = circleArrayQueue.headQueue();
        System.out.println(head2);

        /**
         * 用数组模拟环形队列
         * 1. front 指针调整：指向队列的第一个元素 front=0
         * 2. rear 调整为：指向最后一个元素的后一个位置，因为希望空出一个空间 rear=0
         * 3. 当队列满时：(rear+1) % maxsize = front
         * 4. 队列空：rear == front
         * 5. 队列中有效的数据的个数：（rear + maxsize - front） % maxsize
         */
    }


}
