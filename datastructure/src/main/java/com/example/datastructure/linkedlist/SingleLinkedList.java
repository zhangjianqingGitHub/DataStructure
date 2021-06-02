package com.example.datastructure.linkedlist;

/**
 * 链表
 * 1. 链表是以节点的方式来存储
 * 2. 每个节点包含data域，next域，指向下一个节点。
 * 3. 链表的各个节点不一定是连续存储
 * 4. 带头节点和不带头节点 的两种的链表
 */
public class SingleLinkedList {

    private final HeroNode head = new HeroNode(0, "", "");//初始化头节点，不动


    // 添加（创建）-无序
    // 1. 先创建一个head头节点，作用:表示单链表的头
    // 2. 新加的节点，加入到链表的最后
    public void add(HeroNode node) {
        // 找到当前链表节点最后一个节点；然后将这个节点的next指向 新插入的节点

        //因为head节点不能动，所以需要一个辅助指针
        HeroNode temp = head;

        // 遍历链表,找到最后
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
        } else {
            System.out.printf("该节点编号:%d 已存在!\n", node.mNumber);
        }
    }

    //添加-有序，按照序号添加
    // 1.通过辅助指针首先找到新添加节点的位置
    // 2.新节点.next=temp.next
    // 3.temp.next=新节点
    public void addByOrder(HeroNode node) {
        // 希望temp找到的是位于添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false;//添加的新节点的编号是否已经存在
        while (temp.next != null) {
            if (temp.next.mNumber > node.mNumber) {// 位置找到temp -新 -temp.next
                break;
            } else if (temp.next.mNumber == node.mNumber) {
                //希望添加的节点已存在
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (!flag) {
            node.next = temp.next;
            temp.next = node;
        } else {
            System.out.printf("该节点编号:%d 已存在!\n", node.mNumber);
        }

    }

    // 修改
    public void update(HeroNode node) {
        if (head.next == null) {
            System.out.println("链表为空！");
        } else {
            HeroNode temp = head.next;
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

    public void delete(HeroNode node) {
        if (head.next == null) {
            System.out.println("链表为空！");
        } else {
            HeroNode temp = head;
            boolean flag = false;
            while (temp.next != null) {
                if (temp.next.mNumber == node.mNumber) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.next = temp.next.next;
            } else {
                System.out.println("无此数据！删除失败！");
            }
        }

    }

    // 显示列表
    public void showList() {
        if (head.next == null) {
            System.out.println("链表为空！");
        } else {
            HeroNode temp = head.next;
            while (temp != null) {
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }
    }

    public int getLength() {
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 查找倒数第k个节点
     *
     * @return
     */
    public HeroNode getNode(int k) {
        if (getLength() - k <= 0 || head.next == null) {
            System.out.println("重新指定：" + k + "-" + getLength());
            return null;
        } else {

            HeroNode temp = head.next;
            int index = 0;
            boolean flag = false;
            while (temp != null) {
                if (index == (getLength() - k)) {
                    System.out.printf("倒数第%d个:" + temp.toString(), k);
                    flag = true;
                    break;
                }
                index++;
                temp = temp.next;
            }

            if (flag) {
                return temp;
            } else {
                return null;
            }

        }

    }


}

