package com.example.datastructure.stack;

/**
 * 使用栈实现一个计算器( 一位数 加减乘除 )
 * 1. 创建两个栈，一个存放数，一个存放运算符
 * 2. 通过一个index 遍历表达式
 * 3. 如果发现是一个数字，就直接入数栈（注意多位数）
 * 4. 如果是一个符号：分两种情况，
 * 一，如果当前符号栈为空，就直接入栈；
 * 二，如果不为空，则进行比较，
 * 1. 如果当前的运算符的优先级 <= 栈中的运算符，就需要从数栈中pop两个数，从符号栈pop出一个数，
 * 进行运算，将得到的结果入数栈，然后将当前运算符入符号栈
 * 2. 如果当前的运算符的优先级 > 栈中的运算符 ,就直接入符号栈
 * <p>
 * 5. 当表达式扫描完毕后，就顺序从数栈和符号栈中pop出相应的数和符号，并运算
 * 6. 最后在数栈中只有一个数字，就是表达式的结果
 */
public class Calculator {
    public static void main(String[] args) {

        String expression = "7*2*2-5+1-5+3-4";

        // 创建两个栈，一个数栈，一个符号栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        // 用于扫描表达式
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';// 将每次扫描得到的char保存到ch
        StringBuilder keepNum = new StringBuilder(); // 用于拼接多位数

        while (index <= (expression.length() - 1)) {
            ch = expression.charAt(index);
            // 如果时一个符号
            if (operStack.isOper(ch)) {
                // 如果为空直接入栈
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        // 先出栈一个符号（注意不是当前的ch,而是栈中的符号）
                        oper = operStack.pop();
                        // 把数栈取出的数和符号栈取出的符号做运算
                        res = numStack.cal(num1, num2, oper);
                        // 结果放回数栈
                        numStack.push(res);
                    }
                }
                // 此运算符入符号栈
                operStack.push(ch);
            } else {
                // 当处理多位数时
                keepNum.append(ch);
                if (index != expression.length() - 1) {
                    if (operStack.isOper(expression.charAt(index + 1))) {
                        //后一位是运算符
                        numStack.push(Integer.parseInt(keepNum.toString()));
                        keepNum.delete(0, keepNum.length());
                    }
                } else {
                    numStack.push(ch - '0');
                }
            }
            index++;
        }

        //当表达式扫描完毕后，就顺序从数栈和符号栈中pop出相应的数和符号，并运算
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        // 结束
        System.out.println("表达式:" + expression + "=" + numStack.pop());

    }
}


