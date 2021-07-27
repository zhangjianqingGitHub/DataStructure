package com.example.datastructure.recursion;

/**
 * 八皇后问题
 */
public class Queue8 {

    private final int max = 8;
    private final int[] array = new int[max];
    private static int count = 0;

    public static void main(String[] args) {
        new Queue8().check(0);
        System.out.println("count:" + count);
    }

    //放入皇后
    private void check(int n) {
        if (n == max) {
            print();
            count++;
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后，放到该行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {//不冲突
                //接着放n+1个皇后
                check(n + 1);
            }
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //array[i] == array[n] 表示判断第n个皇后是否和前面的n-1个皇后是否在同一列
            //Math.abs(n - i) == Math.abs(array[n] - array[i]):
            //表示判断第n个皇后是否和第i个皇后是否在同一斜线上
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }

        }
        return true;
    }

    private void print() {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
