package com.example.datastructure.linkedlist;

public class DoubleLinkedList {

    //初始化头节点，不动
    private final HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 双向链表：
     * 1. 遍历方式和单链表一样，只是可以向前也可以向后
     * 2. 添加（默认添加到最后）：先找到双向链表的最后，temp.next=newHead ;newHead.pre=temp
     * 3. 修改和单链表一样
     * 4. 删除：直接找到要删除的节点 。temp.pre.next=temp.next; temp.next.pre=temp.pre;
     */

    // 显示列表
    public void showList() {
        if (head.next == null) {
            System.out.println("链表为空！");
        } else {
            HeroNode2 temp = head.next;
            while (temp != null) {
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }
    }

    public void add(HeroNode2 node) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.mNumber == node.mNumber) {
                flag = true;
                break;
            } else {
                temp = temp.next;
            }
        }

        if (!flag) {
            temp.next = node;
            node.pre = temp; // 这里不同
        } else {
            System.out.printf("该节点编号:%d 已存在!\n", node.mNumber);
        }
    }

    public void update(HeroNode2 node) {
        if (head.next == null) {
            System.out.println("链表为空！");
        } else {
            HeroNode2 temp = head.next;
            boolean flag = false;
            while (temp != null) {
                if (node.mNumber == temp.mNumber) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.mName = node.mName;
                temp.mNickName = node.mNickName;
            } else {
                System.out.println("无此数据！修改失败！");
            }

        }
    }

    public void delete(HeroNode2 node) {
        if (head.next == null) {
            System.out.println("链表为空！");
        } else {
            HeroNode2 temp = head.next;
            boolean flag = false;
            while (temp != null) {
                if (temp.mNumber == node.mNumber) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                // 这里不同
                temp.pre.next = temp.next;

                // 如果temp是最后一个节点，则temp.next=null;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.println("无此数据！删除失败！");
            }
        }

    }

}
