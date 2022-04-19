package com.linearList.LinkedList;

import com.stack_queue.stack.LinkedNode;

public class Node<T> {
    public T data;//元素(数据）
    public Node<T> next; //next指针

    public Node(T data, Node<T> node) {
        this.data = data;
        this.next = node;
    }

    public Node() {
        this(null,null);
    }

    @Override
    public String toString() {
        return "data is:"+data;
    }
}
