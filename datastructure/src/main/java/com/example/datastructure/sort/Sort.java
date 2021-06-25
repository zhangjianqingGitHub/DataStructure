package com.example.datastructure.sort;

import java.util.Arrays;

/**
 * 1. 十种排序： 冒泡排序、选择排序、插入排序、希尔排序、归并排序、
 * 快速排序、堆排序、计数排序、桶排序、基数排序
 * 2. 稳定性：假定在待排序的记录序列中，存在多个具有相同的关键字的记录
 * 若经过排序，这些记录的相对次序保持不变(相同关键字是关键，例如冒泡排序是稳定的，
 * 因为两个数比较，如果相等则没有必要交换）
 */
public class Sort {

    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 快排
     * 1. 平均时间复杂度：nlogn ；空间复杂度：logn
     * 2. 稳定性：不稳定
     * 3. 最坏情况退化成 冒泡排序 （即每次划分都是 n-1 和 1个元素时，退化为冒泡排序）
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
     * 冒泡排序
     * 1. 平均时间复杂度：n^2  空间复杂度 O(1)
     * 2. 稳定性：稳定
     * 3. 冒泡，轻的泡浮起来（小的）
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

    /**
     * 插入排序
     * 1. 平均时间复杂度：O(n^2) ；空间复杂度 O(1)
     * 2. 稳定性： 稳定
     * 3. 思路：
     * * * 1. 从第一个元素开始，该元素可以认为已经被排序
     * * * 2. 取出下一个元素，在已经排序的元素序列中从后往前扫描
     * * * 3. 如果该元素（已排序的元素）大于新元素，将该元素移到下一位
     * * * 4. 重复步骤3，直到找到已排序元素 <= 新元素的位置
     * * * 5. 将新元素插入到该位置后
     * * * 6. 重复步骤 2 - 5
     */
    public static void insertSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }


    /**
     * 希尔排序： 是插入排序的改进版本，本质上也是插入排序
     * 1. 时间复杂度：O(nlogn) ;空间复杂度
     * 2. 思路 eg: length=10
     * * 1. 设置一个增量 gap=length/2=5 ,则从第一个数开始（包括）每数5下的这些数是一组
     * * 2. 将每组分别进行插入排序
     * * 3. 当增量为1时，整个序列就是一组，微调后即排序完成
     */
    public static void shellSort(int[] arr) {
        int length = arr.length;
        int gap = length / 2;
        int temp;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }

    /**
     * 二分查找的递归和非递归实现
     * 1. 前提：有序序列
     */
    public static int recursionBinarySearch(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        int middle = (low + high) / 2;
        if (arr[middle] > key) {
            return recursionBinarySearch(arr, key, low, middle - 1);
        } else if (arr[middle] < key) {
            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }
    }

    public static int commonBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle;

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (key < arr[middle]) {
                high = middle - 1;
            } else if (key > arr[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }


}
