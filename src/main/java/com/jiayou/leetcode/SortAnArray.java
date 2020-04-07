package com.jiayou.leetcode;

import java.util.ArrayList;

/**
 * Create by fz on 2020/3/31
 */
public class SortAnArray {

    public static void main(String[] args) {
        SortAnArray sort = new SortAnArray();
        int[] a = new int[]{5, 2, 3, 1};
        int[] ints = sort.sortArray(a);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private int[] sortArray(int[] a) {
        linklist list = new linklist(a[0]);

        for (int i = 1; i < a.length; i++) {
        }

        return a;
    }

    public int[] sortArray1(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length -1-i; j++) {
                if (nums[j] >= nums[j + 1]) {
                    tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return nums;
    }
}

class linklist{
    public int val ;
    public linklist next;

    public linklist(int a) {
        this.val = a;
    }
}
