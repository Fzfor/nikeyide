package com.jiayou.algorithms.sort;

import java.util.Arrays;

/**
 * Create by fz on 2020/5/11
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6,0};
        shellSort(arr);
    }

    //使用逐步推导的方式来实现希尔排序
    public static void shellSort(int[] arr) {

        /*
        int temp = 0;
        //希尔排序第一轮计算
        //因为第一轮排序，是将10个数据分成了5组
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中的所有元素，共5组，每组2个元素，步长5
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔排序第一轮后 = " + Arrays.toString(arr));

        //第二轮
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中的所有元素，步长2
            for (int j = i - 2; j >= 0; j -= 2) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序第2轮后 = " + Arrays.toString(arr));

        //第3轮
        for (int i = 1; i < arr.length; i++) {
            //遍历各组中的所有元素，2/2=1组，步长1
            for (int j = i - 1; j >= 0; j -= 1) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序第3轮后 = " + Arrays.toString(arr));
        */

        //根据前面的逐步分析，使用循环处理
        int temp = 0;
        for (int a = arr.length / 2; a >= 1; a /= 2) {
            //因为第一轮排序，是将10个数据分成了5组
            for (int i = a; i < arr.length; i++) {
                //遍历各组中的所有元素，共5组，每组2个元素，步长5
                for (int j = i - a; j >= 0; j -= a) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + a]) {
                        temp = arr[j];
                        arr[j] = arr[j + a];
                        arr[j + a] = temp;
                    }
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
