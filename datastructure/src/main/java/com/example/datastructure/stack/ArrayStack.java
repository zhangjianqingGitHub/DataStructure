package com.example.datastructure.stack;

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

    // 查看栈顶
    public int peek() {
        return stack[top];
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

    // 返回运算符的优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    // 判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;// 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
