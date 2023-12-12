package com.linearList.DoubleLinkedList;

public class DoubleNode<T> {
    public T data;         //数据域
    public DoubleNode<T> prev;  //前驱
    public DoubleNode<T> next;  //后驱

    public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DoubleNode() {
        this(null,null,null);
    }
}
