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
        System.out.println();

        System.out.println("开始出圈！");

        linkedList.countBoy(1, 2, 5);
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

    /**
     * 1. 需要创建一个辅助指针 helper,指向环形链表的最后一个节点（指向 5 ）
     * 2. 报数前，先让first 和 helper 移动 start-1 次，因为从那个小孩开始报数
     * 3. 当小孩报数时，让 first 和 helper 同时移动 count-1 次
     * 4. 将first指向的小孩节点出圈  first=first.next ;helper.next=first
     *
     * @param start 表示从第几个小孩开始数
     * @param count 表示数几下
     * @param nums  共有多少小孩
     */
    public void countBoy(int start, int count, int nums) {

        if (first == null || start < 1 || start > nums) {
            System.out.println("参数输入有误！");
        } else {
            Boy helper = first;
            while (helper.getNext() != first) {
                helper = helper.getNext(); // helper指向最后一个小孩 （5）
            }

            // 移动到 start 开始位置
            for (int i = 0; i < start - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            // 出圈
            while (helper != first) { // 出循环时只剩一人

                for (int i = 0; i < count - 1; i++) {
                    first = first.getNext();
                    helper = helper.getNext();
                }

                // 这时 first 指向的节点，就是要出圈的小孩
                System.out.printf("小孩 %d 出圈\n", first.getNo());
                first = first.getNext();
                helper.setNext(first);

            }

            System.out.printf("最后留在圈中的小孩编号是 %d \n", first.getNo());

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
