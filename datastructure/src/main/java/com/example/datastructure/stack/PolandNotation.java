package com.example.datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 前缀表达式 (波兰表达式)
 * 1. 运算符位于操作数之前
 * 2. 举例说明 （3+4）*5-6 对应的前缀表达式就是 -*+3456
 * 3. 从右向左扫描，遇到数字时，将数字压入堆栈;
 * 遇到运算符时，弹出栈顶的两个数，用运算符对他们做相应的计算, 并将结果入栈;
 * 4. 重复上述过程知道表达式最左端
 * <p>
 * 中缀表达式 就是最常见的运算表达式 （3+4）*5-6 ，是人最熟悉的，但是对计算机不友好，所以一般将中缀表达式
 * 转为其他表达式，一般转为后缀表达式
 * <p>
 * 后缀表达式（逆波兰表达式）
 * 1. 运算符位于操作数之后 34+5*6-
 * 2. 从左到右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，
 * 用运算符对他们做相应计算，并将结果入栈
 */
public class PolandNotation { // 逆波兰计算器（后缀表达式）
    public static void main(String[] args) {
        // 先定义一个逆波兰表达式
        String suffixExpression = "30 4 + 5 * 6 -";
        // 1.先将表达式放在 arraylist中
        // 2.将list传递给一个方法，配合栈完成计算

        List<String> list = getListString(suffixExpression);
        System.out.println(list);
        int res = calculate(list);
        System.out.println(res);
    }

    public static List<String> getListString(String suffixExpression) {
        return new ArrayList<>(Arrays.asList(suffixExpression.split(" ")));
    }

    public static int calculate(List<String> list) {
        // 创建一个栈，只需要一个栈
        Stack<String> stringStack = new Stack<>();
        for (String str : list) {
            if (str.matches("\\d+")) { //匹配多位数 ,使用正则表达式
                // 直接入栈
                stringStack.push(str);
            } else {
                // pop出两个数，运算
                int num1 = Integer.parseInt(stringStack.pop());
                int num2 = Integer.parseInt(stringStack.pop());
                int res = 0;
                switch (str) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("运算符有误！");
                }
                stringStack.push(res + "");
            }
        }

        return Integer.parseInt(stringStack.pop());
    }
}
