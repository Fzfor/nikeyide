package com.jiayou.algorithms.queue;

import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_UDS;

import java.util.Scanner;

/**
 * Create by fz on 2020/3/24
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        char value = ' ';
        ArrayQueue queue = new ArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("s(show):展示队列");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):获取数据");
            System.out.println("e(exit):退出");
            System.out.println("h(head):取出头数据");
            value = scanner.next().charAt(0);

            switch (value) {
                case 'a':
                    if (queue.isFull()) {
                        System.out.println("队列已满，无法添加");
                    }
                    System.out.println("请输入数据");
                    int a = scanner.nextInt();
                    queue.add(a);
                    break;
                case 's':
                    try {
                        queue.getList();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    if (queue.isEmpty()) {
                        System.out.println("队列为空，请先添加数据");
                    }
                    try {
                        System.out.println("取出数据为：" + queue.get());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    if (queue.isEmpty()) {
                        System.out.println("队列为空，请先添加数据");
                    }
                    queue.peekFirst();
                    break;
                case 'e':
                    flag = false;
                    System.out.println("程序退出");
                    break;

            }

        }
    }
}


class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;

    private int[] arr;

    /*
    初始化
     */
    public ArrayQueue(int size) {
        this.maxSize = size;
        front = -1;//指向队列第一个的前一个位置
        rear = -1;//指向队列最后一个位置

        arr = new int[maxSize];
    }

    public void peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法遍历");
        }
        System.out.println(arr[front + 1]);
    }

    /**
     * 遍历队列
     */
    public void getList() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法遍历");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 获取数据
     *
     * @return
     */
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取数据");
        }
        //将指针往后移动一位
        front++;
        return arr[front];
    }

    /**
     * 添加数据
     *
     * @param value
     */
    public void add(int value) {
        if (isFull()) {
            System.out.println("队列已满，不能添加");
            return;
        }
        rear++;//指针移到后一位
        arr[rear] = value;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 判断队列是否已经满了
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

}