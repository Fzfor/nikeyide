package com.jiayou.algorithms.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Create by fz on 2020/5/6
 */
public class BubbleSort {
    public static void main(String[] args) {
        //为了容易理解，我们把冒泡排序的演变过程给大家展示
        //int[] arr = {3, 9, -1, 10, -2};

        //测试冒泡排序速度，给80000个数据，测试
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

//        System.out.println(Arrays.toString(arr));
        Date date1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = dateFormat.format(date1);
        System.out.println("排序前的时间是"+dateStr1);

        //测试冒泡排序
        bubbleSort(arr);

        Date date2 = new Date();
        String dateStr2 = dateFormat.format(date2);
        System.out.println("排序后的时间是"+dateStr2);




        /*
        //第二趟排序，就是将第二大的数排在倒数第二位
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                //如果前面的数比后面的大，则交换
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组：");
        System.out.println(Arrays.toString(arr));

        //第三趟排序，就是将第三大的数排在倒数第三位
        for (int i = 0; i < arr.length - 1 - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                //如果前面的数比后面的大，则交换
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组：");
        System.out.println(Arrays.toString(arr));

        //第四趟排序，就是将第四大的数排在倒数第四位
        for (int i = 0; i < arr.length - 1 - 3; i++) {
            if (arr[i] > arr[i + 1]) {
                //如果前面的数比后面的大，则交换
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组：");
        System.out.println(Arrays.toString(arr));
        */
    }

    /**
     * 将冒泡排序算法，封装成一个方法
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        //表示变量，表示是否进行过交换
        boolean flag = false;

        //冒泡排序的时间复杂度O(n^2)
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    //如果前面的数比后面的大，则交换
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
//            System.out.println("第"+(j+1)+"趟排序后的数组：");
//            System.out.println(Arrays.toString(arr));

            if (!flag) { //在一趟排序中，一次也没有交换
                break;
            } else {
                flag = false; //重置flag，进行下次判断
            }

        }
    }
}
