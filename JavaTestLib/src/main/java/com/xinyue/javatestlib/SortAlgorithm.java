package com.xinyue.javatestlib;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] a = {46, 30, 82, 90, 56, 17, 95, 15};
        int start = 0;
        int end = a.length - 1;
        sort(a, start, end);
        for (int anA : a) {
            System.out.println(anA);
        }
    }

    public static void sort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int baseNum = arr[low];

        while (l < h) {
            //1.从右向左查找小于指定基数的数，找到之后跳出循环执行下面if循环，交换数据
            while (l < h && arr[h] >= baseNum) {
                h--;
            }
            //交换数据
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            //2.从左向右查找大于指定基数的数，找到后跳出循环执行下面if循环，交换数据
            while (l < h && arr[l] <= baseNum)
                l++;
            //交换数据
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        if (l > low) {
            sort(arr, low, l - 1);
        }
        if (h < high) {
            sort(arr, l + 1, high);
        }
    }
}
