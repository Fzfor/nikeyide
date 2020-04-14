package com.jiayou.algorithms.linkedList;

/**
 * Create by fz on 2020/4/10
 */
public class Josepfu {
    public static void main(String[] args) {
        //测试，看看构建环形列表，和遍历方法是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);//加入5个小孩节点
        circleSingleLinkedList.showBoy();

        //测试小孩出圈
        circleSingleLinkedList.countBoy(10,20,125);//2 4 1 5 3
    }
}

//创建一个环形链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first = null;

    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums数值不正确");
            return;
        }
        //辅助指针
        Boy curBoy = null;
        //使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            //根据标号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }

        //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号是： %d \n",curBoy.getNo());
            if (curBoy.getNext() == first) {
                //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();//curBoy后移
        }
    }

    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (startNo > nums || first == null || countNum <1) {
            System.out.println("输入的参数不正确，请重新输入");
            return;
        }
        //创建辅助指针，帮助完成小孩出圈
        Boy helper = first;

        //helper指针事先应该指向环形链表的最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        //小孩报数前，先让first和helper移动K-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，让first和helper指针同时移动m-1次，然后出圈
        //这里是一个循环操作，
        while (true) {
            if (helper == first) {//说明圈中只有一个小孩
                break;
            }
            //让helper和fist同时移动countNum-1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这是first指向的节点，就是要出圈的节点
            System.out.println("出圈的小孩编号是： "+first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中小孩的编号是%d",first.getNo());

    }
}

//创建一个Boy类，表示一个节点
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
