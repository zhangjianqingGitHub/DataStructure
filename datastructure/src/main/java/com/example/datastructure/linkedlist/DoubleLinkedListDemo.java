package com.example.datastructure.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        DoubleLinkedList linkedList = new DoubleLinkedList();

        HeroNode2 node1 = new HeroNode2(0, "宋江", "及时雨");
        HeroNode2 node2 = new HeroNode2(1, "吴用", "智多星");
        HeroNode2 node3 = new HeroNode2(2, "林冲", "豹子头");

        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);


        linkedList.update(new HeroNode2(1,"小张","强无敌"));

        linkedList.showList();

        linkedList.delete(node3);

        System.out.println();
        linkedList.showList();


    }


}
