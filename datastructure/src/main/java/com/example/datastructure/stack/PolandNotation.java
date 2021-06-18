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

        String expression = "1+((2+3)*4)-5";
        System.out.println(expression);
        System.out.println();
        // 字符串转为list ,不能直接转，以为可能会有多位数
        List<String> list1 = toInfixExpressionList(expression);
        System.out.println(list1);
        System.out.println();
        //中缀表达式 -> 后缀表达式
        List<String> list2 = parseSuffixExpression(list1);
        System.out.println(list2);
        System.out.println();
        //计算
        int res1 = calculate(list2);
        System.out.println(expression + "=" + res1);
    }

    /**
     * 中缀表达式 转 后缀表达式
     * 1. 初始化两个栈， 运算符栈 s1 和 储存中间结果的栈 s2 (S2没有出栈操作，可以用list代替)
     * 2. 从左至右扫描中缀表达式
     * 3. 遇到操作数时，将其压入 s2
     * 4. 遇到运算符时，比较其与 s1栈顶运算符的优先级
     * 1).如果s1为空吗，或栈顶运算符为左括号“（” ,则直接将此运算符压入栈
     * 2).否则，若优先级比栈顶运算符的高，压入s1
     * 3).否则将s1栈顶运算符弹出并压入到s2中，再次重复第 4 步与s1中新的栈顶运算符比较
     * 5. 遇到括号时：（括号不是运算符）
     * 1). 如果时左括号"(“ 则直接压入栈
     * 2). 如果时右括号")" 则依次弹出s1栈顶的运算符，直到遇到左括号为止，此时将这一对括号丢弃
     * 6. 重复步骤2-5，直到表达式最右端
     * 7. 将s1中剩余的运算符依次弹出并压入s2
     * 8. 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     */
    public static List<String> parseSuffixExpression(List<String> infixExpressionList) {
        Stack<String> s1 = new Stack<>();// 符号栈
        List<String> s2 = new ArrayList<>(); // 因为没有pop操作且最后需要逆序输出，用list代替

        for (String str : infixExpressionList) {
            // 如果是一个数,加入s2
            if (str.matches("\\d+")) {
                s2.add(str);
            } else if (str.equals("(")) {
                s1.push(str);
            } else if (str.equals(")")) {
                // 右括号
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); // 将这个小括号（ 弹出
            } else {
                // 当str的优先级<=栈顶运算符
                while (s1.size() != 0 && getValue(s1.peek()) >= getValue(str)) {
                    s2.add(s1.pop());
                }
                s1.push(str);
            }
        }

        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2; //因为是存放到list，因此按顺序输出就是逆波兰表达式

    }


    public static List<String> toInfixExpressionList(String s) {
        List<String> list = new ArrayList<>();
        int index = 0; //用于遍历字符串
        StringBuilder str = new StringBuilder(); // 用于拼接多位数
        char ch; // 每遍历一个字符，就放入c

        while (index < s.length()) {
            //如果是一个非数字
            if (s.charAt(index) < 48 || s.charAt(index) > 57) {
                ch = s.charAt(index);// 是一个非数字
                list.add(ch + "");
                index++;
            } else {// 如果是一个数，需要考虑多位数问题
                str.delete(0, str.length());

                while (index < s.length() && s.charAt(index) >= 48 && s.charAt(index) <= 57) {
                    ch = s.charAt(index);
                    str.append(ch);
                    index++;
                }
                list.add(str.toString());

            }
        }
        return list;
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

    public static int getValue(String operation) {
        int res = 0;
        switch (operation) {
            case "+":
            case "-":
                res = 1;
                break;
            case "*":
            case "/":
                res = 2;
                break;
            default:
                break;
        }
        return res;
    }
}
