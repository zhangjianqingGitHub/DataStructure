package com.example.datastructure.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();

        HeroNode node1 = new HeroNode(0, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(1, "吴用", "智多星");
        HeroNode node3 = new HeroNode(2, "林冲", "豹子头");

//        linkedList.add(node1);
//        linkedList.add(node3);
//        linkedList.add(node2);
//        linkedList.add(node2);

        linkedList.addByOrder(node1);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node2);
//
//        HeroNode node4 = new HeroNode(2, "小张", "666");
//        linkedList.update(node4);
//        linkedList.delete(node4);

//        linkedList.showList();
//        int length = linkedList.getLength();
//        System.out.println("链表长度：" + length);
//        linkedList.findLastIndexNode(1);

//        linkedList.revertList(linkedList.getHead());
//        System.out.println("链表反转：");
//        linkedList.showList();

        linkedList.reversePrintByStack(linkedList.getHead());

    }
}
