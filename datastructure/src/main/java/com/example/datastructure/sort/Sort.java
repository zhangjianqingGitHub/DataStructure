package com.example.datastructure.sort;

import java.util.Arrays;

/**
 * 1. 十种排序： 冒泡排序、选择排序、插入排序、希尔排序、归并排序、
 * 			快速排序、堆排序、计数排序、桶排序、基数排序
 * 2. 稳定性：假定在待排序的记录序列中，存在多个具有相同的关键字的记录
 *          若经过排序，这些记录的相对次序保持不变(相同关键字是关键，例如冒泡排序是稳定的，
 *          因为两个数比较，如果相等则没有必要交换）
 */
public class Sort {

    public static void main(String[] args) {

        int[] arr = {0, 5, 3, 8, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    /**
     快排
     1. 平均时间复杂度：nlogn ；空间复杂度：logn
     2. 稳定性：不稳定
     3. 最坏情况退化成 冒泡排序 （即每次划分都是 n-1 和 1个元素时，退化为冒泡排序）
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int key = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (key <= arr[j] && i < j) {
                j--;
            }

            while (key >= arr[i] && i < j) {
                i++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        if (i == j) {
            arr[low] = arr[i];
            arr[i] = key;
        }

        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    /**
     冒泡排序
     1. 平均时间复杂度：n^2  空间复杂度 O(1)
     2. 稳定性：稳定
     3. 冒泡，轻的泡浮起来（小的）
     */
    public static void bubbleSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        // length -1 是因为最后一个数不能和下一个数比较了，所以循环到倒数第二个数
        for (int i = 0; i < arr.length - 1; i++) {

            //length-1-i 是因为，经过一趟后，最后一个数就是最大的数，所以不用比较了
            for (int j = 0; j < arr.length - 1 - i; j++) {

                // 后一个比前一个小,则交换，这样后，小的到前面了
                // 注意这里是 j 和 j+1 比较
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 1. 平均时间负责度： O(n^2)  ;空间复杂度：O(1)
     * 2. 稳定性：不稳定
     * 3. 找最小的放前面，从剩下的里面再找最小的
     */
    public static void selectSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            int temp = arr[minValueIndex];
            arr[minValueIndex] = arr[i];
            arr[i] = temp;
        }
    }


}
