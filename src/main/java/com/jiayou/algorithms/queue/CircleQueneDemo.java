package com.jiayou.algorithms.queue;

import java.util.Scanner;

/**
 * Create by fz on 2020/3/29
 */
public class CircleQueneDemo {
    public static void main(String[] args) {
        char value = ' ';
        CircleQuene queue = new CircleQuene(4);
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

class CircleQuene {
    private int maxSize;
    private int front;
    private int rear;

    private int[] arr;

    /*
    初始化
     */
    public CircleQuene(int size) {
        this.maxSize = size;
        front = 0;//指向队列第一个
        rear = 0;//指向队列最后一个位置的后一个位置

        arr = new int[maxSize];
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
        arr[rear] = value;
        rear = (rear + 1) % maxSize;//指针移到后一位
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
        int result = arr[front];
        front = (front + 1) % maxSize;
        return result;
    }

    /**
     * 遍历队列
     */
    public void getList() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法遍历");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public void peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法遍历");
        }
        System.out.println(arr[front]);
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
        return (rear + 1) % maxSize == front % maxSize;
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

}
