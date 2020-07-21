package com.jiayou.algorithms.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Create by fz on 2020/5/9
 */
public class InsertSort {
    public static void main(String[] args) {
        //int[] arr = {101, 34, 119, 1,-1,89};

        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        String dateStr1 = dateFormat.format(date1);
        System.out.println("排序前的时间是"+dateStr1);

        insertSort(arr);

        Date date2 = new Date();
        String dateStr2 = dateFormat.format(date2);
        System.out.println("排序后的时间是"+dateStr2);


    }

    //插入排序
    public static void insertSort(int[] arr) {

        /*
        //使用逐步推论的方式讲解，便于理解
        //第一轮{101, 34, 119, 1}->{34, 101, 119, 1}

        //定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1;    //即arr[1]前面这个数的下标

        //给insertVal找到插入位置
        //说明
        //1.inserIndex >= 0 保证在给insertVal找插入位置，不越界
        //2.insertVal < arr[insertIndex] 待插入的数还没找到插入位置
        //3.就需要将arr[insertIndex] 后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex -- ;
        }
        //当退出while循环时，说明插入位置找到，insertIndex+1
        arr[insertIndex + 1] = insertVal;

        System.out.println("第一轮 ~");
        System.out.println(Arrays.toString(arr));

        //第二轮
        insertVal = arr[2];
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex -- ;
        }
        //当退出while循环时，说明插入位置找到，insertIndex+1
        arr[insertIndex + 1] = insertVal;

        System.out.println("第二轮 ~");
        System.out.println(Arrays.toString(arr));

        //第三轮
        insertVal = arr[3];
        insertIndex = 3 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex -- ;
        }
        //当退出while循环时，说明插入位置找到，insertIndex+1
        arr[insertIndex + 1] = insertVal;

        System.out.println("第三轮 ~");
        System.out.println(Arrays.toString(arr));
        */

        int insertVal = 0;
        int insertIndex = 0;

        //使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1;    //即arr[1]前面这个数的下标

            //给insertVal找到插入位置
            //说明
            //1.inserIndex >= 0 保证在给insertVal找插入位置，不越界
            //2.insertVal < arr[insertIndex] 待插入的数还没找到插入位置
            //3.就需要将arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex -- ;
            }

            //当退出while循环时，说明插入位置找到，insertIndex+1
            //判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

//            System.out.println("第"+i+"轮 ~");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
