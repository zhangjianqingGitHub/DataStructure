package com.example.datastructure.recursion;

/**
 * 递归调用规则：
 * 1.当程序执行到一个方法时，就会开辟一个独立的空间（栈）
 * 2.每个空间的数据（基本数据类型、局部变量、栈中），是独立的；
 *   如果方法中使用的是引用类型的变量（eg：数组），则共享该引用数据(堆中)
 * 3.递归必须向退出递归的条件逼近
 */
public class RecursionTest {
    public static void main(String[] args) {

//        test(10);
//        int res = factorial(3);
//        System.out.println(res);

      test t=  new test(){
            @Override
            public void a() {
                System.out.println(this.getClass());
            }
        };

      t.a();
    }

    //打印问题
    private static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    //阶乘问题
    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    abstract static class test{
      abstract public void a();
    }

}

