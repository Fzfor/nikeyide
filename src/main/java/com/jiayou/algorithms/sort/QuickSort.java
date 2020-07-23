package com.jiayou.algorithms.sort;


import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * @author fzfor
 * @create 2020-07-15 16:09
 */
public class QuickSort {
    public static void main(String[] args) {
        //int[] ints = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        //int[] ints = {5,8,7,5,3,2,4};


        int[] arr = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        String dateStr1 = dateFormat.format(date1);
        System.out.println("排序前的时间是"+dateStr1);

        quickSort(arr,0,arr.length-1);

        Date date2 = new Date();
        String dateStr2 = dateFormat.format(date2);
        System.out.println("排序后的时间是"+dateStr2);
    }

    public static void quickSort(int[] arr, int l, int r) {
        int left = l;
        int right = r;

        int pivot = arr[(l + r) / 2];//中轴
        int temp = 0;//临时变量用于交换

        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;//当比中轴小，指针向右移一位
            }

            while (arr[r] > pivot) {
                r -= 1;//当比中轴大，指针向左移一位
            }

            if (l >= r) {//中轴两边已经比较完毕，退出循环
                break;
            }

            //开始交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r){
            quickSort(arr,left,r);
        }
        if (l < right){
            quickSort(arr,l,right);
        }
    }
}
