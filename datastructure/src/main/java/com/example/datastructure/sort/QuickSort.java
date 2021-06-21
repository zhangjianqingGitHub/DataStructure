package com.example.datastructure.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {0, 5, 3, 8, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

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

}
