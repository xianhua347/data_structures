package com.stack_queue.queue;

import com.stack_queue.stack.LinkedNode;

public class LinkedQueue<T> implements Queue<T> {
    private final LinkedNode<T> front;  //头节点
    private LinkedNode<T> rear;  // 尾节点

    public LinkedQueue() {
        front = rear = new LinkedNode<>();
    }

    @Override
    public void enqueue(T data) {
        final LinkedNode<T> linkedNode = new LinkedNode<>(data, null);
        rear.setNext(linkedNode); //插入队尾
        rear = linkedNode; //移动rear指针 指向linkedNode节点
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("queue is null");
        final LinkedNode<T> node = front.getNext(); //保存要删除的节点
        front.setNext(node.getNext()); //队列front指向node的后继节点 完成删除操作
        if (node.getNext() == null) rear = front; //如果只有一个元素 那就把尾指针指向头指针
        return node.getData(); //返回要删除的节点
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("queue is null");
        return front.getNext().getData();
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    public int length(){
        int count = 0;
        LinkedNode<T> front = this.front;
        final LinkedNode<T> rear = this.rear;
        while (front != rear) {
            count++;
            front = front.getNext(); //头节点移动直到front == rear
        }
        return count;
    }
}
