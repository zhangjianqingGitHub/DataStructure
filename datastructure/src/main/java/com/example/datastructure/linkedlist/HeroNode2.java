package com.example.datastructure.linkedlist;

public class HeroNode2 {
    public int mNumber;
    public String mName;
    public String mNickName;//昵称
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
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
