package com.jiayou.leetcode;

import java.util.List;

/**
 * Create by fz on 2020/3/28
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        while (true) {
            System.out.println(listNode.val);
            if (listNode.next == null) {
                break;
            } else {
                listNode = listNode.next;
            }
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long a = 0;
        long b = 0;
        long index1 = -1;
        long index2 = -1;

        while (true) {
            index1++;
            double power =  Math.pow(10, index1); //10 ^ index1 ;
            a += l1.val * power;
            if (l1.next == null) {
                break;
            } else {
                l1 = l1.next;
            }
        }
        while (true) {
            index2++;
            double power =  Math.pow(10, index2);//10 ^ index2;
            b += l2.val * power;
            if (l2.next == null) {
                break;
            } else {
                l2 = l2.next;
            }
        }

        double result = a + b;

        double result1 = result;
        //判断和为几位数
        int unit = 1;
        while (true) {
            if (result1 >= 10) {
                unit++;
                result1 = result1 / 10;
            } else {
                break;
            }
        }

        //创建一个数组，填充结果的各个位上的数字
        ListNode[] vals = new ListNode[unit];
        for (int i = 0; i < unit; i++) {
            int value =  (int)(result %  Math.pow(10, i + 1) /  Math.pow(10, i)); //result % 10 ^ (i + 1) / 10 ^ i;
            vals[i] = new ListNode(value);
        }

        for (int i = 0; i < vals.length - 1; i++) {
            vals[i].next = vals[i + 1];
        }

        return vals[0];

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}