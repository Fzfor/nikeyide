package com.jiayou.algorithms.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by fz on 2020/5/8
 */
public class SelectSort {
    public static void main(String[] args) {
        //int[] arr = {101, 34, 119, 1};

        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        String dateStr1 = dateFormat.format(date1);
        System.out.println("排序前的时间是"+dateStr1);

        sort(arr);

        Date date2 = new Date();
        String dateStr2 = dateFormat.format(date2);
        System.out.println("排序后的时间是"+dateStr2);
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        //使用逐步推导的方式来讲解选择排序

        //第一轮
        //原始的数组：101,34,119,1
        //第一轮排序：1,34,119,101
        //算法：先简单后复杂 逐步解决

        /*
        //第一轮
        int minIndex = 0;
        int min = arr[0];
        for (int i = 0 + 1; i < arr.length; i++) {
            if (min > arr[i]) {  //说明假定的最小值，并不是最小
                min = arr[i];   //重置min
                minIndex = i;   //重置minIndex
            }
        }
        //将最小值放在arr[0] 即交换
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }

        System.out.println("第一轮后~~");
        System.out.println(Arrays.toString(arr));   //1, 34, 119, 101

        //第二轮
        minIndex = 1;
        min = arr[1];
        for (int i = 1 + 1; i < arr.length; i++) {
            if (min > arr[i]) {  //说明假定的最小值，并不是最小
                min = arr[i];   //重置min
                minIndex = i;   //重置minIndex
            }
        }
        //将最小值放在arr[1] 即交换
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        System.out.println("第二轮后~~");
        System.out.println(Arrays.toString(arr));   //1, 34, 119, 101

        //第三轮
        minIndex = 2;
        min = arr[2];
        for (int i = 2 + 1; i < arr.length; i++) {
            if (min > arr[i]) {  //说明假定的最小值，并不是最小
                min = arr[i];   //重置min
                minIndex = i;   //重置minIndex
            }
        }
        //将最小值放在arr[2] 即交换
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("第三轮后~~");
        System.out.println(Arrays.toString(arr));   //1, 34, 101, 119
        */

        //推导过程中发现了规律，使用for循环
        for (int j = 0; j < arr.length - 1; j++) {
            int minIndex = j;
            int min = arr[j];
            for (int i = j + 1; i < arr.length; i++) {
                if (min > arr[i]) {  //说明假定的最小值，并不是最小
                    min = arr[i];   //重置min
                    minIndex = i;   //重置minIndex
                }
            }
            //将最小值放在arr[j] 即交换
            if (minIndex != j) {
                arr[minIndex] = arr[j];
                arr[j] = min;
            }

//            System.out.println("第"+(j+1)+"轮后~~");
//            System.out.println(Arrays.toString(arr));
        }

    }
}
