package com.jiayou.algorithms.sort;

import java.util.Arrays;

/**
 * @author fzfor
 * @create 2020-07-25 15:38
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 9, 4, 6, 8, 12, 14, 34};
        System.out.println(Arrays.toString(arr));
        merge(arr, 0, 5, arr.length - 1, new int[12]);
        System.out.println(Arrays.toString(arr));
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
