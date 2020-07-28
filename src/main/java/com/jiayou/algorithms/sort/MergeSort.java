package com.jiayou.algorithms.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author fzfor
 * @create 2020-07-25 15:38
 */
public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = {41, 12, 4, 5676, 7, 649, 4, 6, -908, 12, 23414, 34};
        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        String dateStr1 = dateFormat.format(date1);
        System.out.println("排序前的时间是"+dateStr1);

        splitSort(arr,0,7999,new int[80000]);

        Date date2 = new Date();
        String dateStr2 = dateFormat.format(date2);
        System.out.println("排序后的时间是"+dateStr2);
    }

    public static void splitSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right) / 2;

            splitSort(arr,left,mid,temp);
            splitSort(arr,(mid + 1),right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * @param arr   要合并的数据
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param tmp   中转的索引
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        int firstArrIndex = left;
        int secondArrIndex = mid + 1;
        int tmpIndex = 0;

        while (firstArrIndex <= mid && secondArrIndex <= right) {
            if (arr[firstArrIndex] <= arr[secondArrIndex]) {
                tmp[tmpIndex] = arr[firstArrIndex];
                firstArrIndex += 1;
                tmpIndex += 1;
            } else {
                tmp[tmpIndex] = arr[secondArrIndex];
                tmpIndex += 1;
                secondArrIndex += 1;
            }
        }

        while (firstArrIndex <= mid) {
            tmp[tmpIndex] = arr[firstArrIndex];
            tmpIndex++;
            firstArrIndex++;
        }

        while (secondArrIndex <= right) {
            tmp[tmpIndex] = arr[secondArrIndex];
            tmpIndex++;
            secondArrIndex++;
        }

        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        tmpIndex = 0;
        int tempLeft = left; //
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = tmp[tmpIndex];
            tmpIndex += 1;
            tempLeft += 1;
        }


    }
}
