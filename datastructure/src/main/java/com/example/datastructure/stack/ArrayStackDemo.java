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

