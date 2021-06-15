package com.example.datastructure.stack;

/**
 * 数组模拟栈的思路
 * 1. 定义一个 top 表示栈顶，初始化为-1
 * 2。 入栈：top++,stack[top]=data
 * 3.  出栈 int value=stack[top] ;top--; return value
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();

        stack.showStack();


    }
}

/**
 * 先入后出 的 有序列表
 * 栈时限制性线性表中元素的插入和删除只能在线性表的同一端进行的一种特殊线性表，
 * 允许插入和删除的一端，为变化的一端，称为栈顶；固定的一端为栈底
 */
class ArrayStack {
    private final int maxSize; // 栈的大小
    private final int[] stack; // 数组，模拟栈，数据放在该数组
    private int top = -1; // 表示栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
        } else {
            top++;
            stack[top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        } else {
            int value = stack[top];
            top--;
            return value;
        }
    }

    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈空");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack[%d]=%d \n", i, stack[i]);
            }
        }
    }

}