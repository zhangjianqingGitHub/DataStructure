package com.example.datastructure.linkedlist;

public class HeroNode {
    public int mNumber;
    public String mName;
    public String mNickName;//昵称
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        mNumber = no;
        mName = name;
        mNickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "mNumber=" + mNumber +
                ", mName='" + mName + '\'' +
                ", mNickName='" + mNickName + '\'' +
                '}';
    }
}
