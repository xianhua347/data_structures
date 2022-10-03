package com.hash;

public class HashItem {
    public int key;
    public  int flag; //flag 0:空闲 1：占用

    public HashItem(int key, int flag) {
        super();
        this.key = key;
        this.flag = flag;
    }

    public HashItem(int flag) {
        super();
        this.flag = flag;
    }
}
