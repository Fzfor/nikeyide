package com.jiayou.algorithms.linkedList;

/**
 * Create by fz on 2020/4/7
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("测试双向链表");

        HeroNode2 hero1 = new HeroNode2(1, "James", "詹皇");
        HeroNode2 hero2 = new HeroNode2(2, "KD", "阿杜");
        HeroNode2 hero3 = new HeroNode2(3, "CLuo", "cluo");
        HeroNode2 hero4 = new HeroNode2(4, "拳王", "嘴炮");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        HeroNode2 newHero = new HeroNode2(4, "Bioge", "表哥");
        doubleLinkedList.update(newHero);
        System.out.println("修改后：");
        doubleLinkedList.list();

        doubleLinkedList.del(4);
        System.out.println("删除后");
        doubleLinkedList.list();

        doubleLinkedList.addByOrder(new HeroNode2(1,""," "));
        System.out.println("顺序添加后");
        doubleLinkedList.list();

    }
}


class DoubleLinkedList{
    //先初始化一个头结点，头节点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 顺序添加
     * @param heroNode
     */
    public void addByOrder(HeroNode2 heroNode) {
        if (head.next == null) {
            head.next = heroNode;
        }
        //因为头节点不能动， 因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表， 因为我们找的 temp 是位于 添加位置的前一个节点， 否则插入不了
        HeroNode2 temp = head;
        boolean flag = false; // flag 标志添加的编号是否存在， 默认为 false
        while(true) {

            if(temp.no > heroNode.no) { //位置找到， 就在 temp 的后面插入
                break;
            } else if (temp.no == heroNode.no) {//说明希望添加的 heroNode 的编号已然存在
                flag = true; //说明编号存在
                break;
            } else if (temp.next == null) {//说明 temp 已经在链表的最后
                break;
            }
            temp = temp.next; //后移， 遍历当前链表
        }

        //判断 flag 的值
        if(flag) { //不能添加， 说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            heroNode.pre = temp.pre;
            heroNode.next = temp;
            temp.pre.next = heroNode;
            temp.pre = heroNode;

        }
    }

    /**
     * 删除节点
     * 可以直接找到要删除的节点，找到后，自我删除
     * @param no
     */
    public void del(int no) {
        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false; // 标志是否找到待删除节点的
        while(true) {
            if(temp == null) { //已经到链表的最后
                break;
            }
            if(temp.no == no) {
                //找到的待删除节点的前一个节点 temp
                flag = true;
                break;
            }
            temp = temp.next; //temp 后移， 遍历
        }

        //判断 flag
        if(flag) { //找到
            //可以删除
            temp.pre.next = temp.next;
            //如果是最后一个节点，就不需要执行下面这句话，否则出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    /**
     * 修改一个节点
     * @param newHeroNode
     */
    public void update(HeroNode2 newHeroNode) {
        //判断是否空
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }

        //找到需要修改的节点, 根据 no 编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while(true) {
            if (temp == null) {
                break; //已经遍历完链表
            } if(temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //根据 flag 判断是否找到要修改的节点
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { //没有找到
            System.out.printf("没有找到 编号 %d 的节点， 不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 添加一个节点到双向链表最后
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {
        //因为 head 节点不能动， 因此我们需要一个辅助遍历 temp
        HeroNode2 temp = head;

        //遍历链表， 找到最后
        while(true) {
            //找到链表的最后
            if(temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将 temp 后移
            temp = temp.next;
        }
        //当退出 while 循环时， temp 就指向了链表的最后
        //将最后这个节点的 next 指向 新的节点
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //遍历双向列表的方法
    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //因为头节点， 不能动， 因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将 temp 后移， 一定小心
            temp = temp.next;
        }
    }
}


//定义 HeroNode ， 每个 HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 pre; //指向前一个节点
    //构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法， 我们重新 toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}