package com.example.datastructure.linkedlist;

/**
 * 约瑟夫问题（单向环形链表）
 * 设编号为 1，2，3...n 的 n 个人围坐一圈，约定编号为 k(i<=k<=n) 的人从 1开始，数到m的那个人出列
 * 他的下一位又开始从 1 开始报数，数到 m 又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
 */
public class Josephu {

    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();

        linkedList.addBoy(5);

        linkedList.showBoy();
    }
}

/**
 * 单向环形链表
 * // 构建一个单向环形列表思路
 * // 1. 先创建一个节点，让first指向该节点，并形成环形
 * // 2. 后面当我们每创建一个新的节点，就把该节点，加入到已有的环形链表中即可。
 */
class CircleSingleLinkedList {
    private Boy first = null;

    // 添加小孩系欸但，构成一个环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("index值不正确");
        } else {
            Boy curBoy = null; // 辅助指针，帮住构建环形链表

            for (int i = 1; i <= nums; i++) {
                Boy boy = new Boy(i);

                if (i == 1) {
                    first = boy;
                    first.setNext(first);
                    curBoy = first;
                } else {
                    curBoy.setNext(boy);
                    boy.setNext(first);
                    curBoy = boy;
                }
            }

        }
    }

    /**
     * // 遍历环形列表
     * // 1. 先让一个辅助指针，指向first节点
     * // 2. 然后通过一个while循环遍历环形链表即可 cur.next==first
     */
    public void showBoy() {
        if (first == null) {
            System.out.println("链表空！");
        } else {

            Boy curBoy = first;
            while (true) {
                System.out.printf("小孩的编号:%d\n ", curBoy.getNo());
                if (curBoy.getNext() != first) {
                    curBoy = curBoy.getNext();// 后移
                } else {
                    break;
                }
            }

        }
    }


}

class Boy {
    private int no; //编号
    private Boy next; // 指向下一个节点,默认为null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
