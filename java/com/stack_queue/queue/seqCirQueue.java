package com.linearList.stack_queue.queue;

import java.util.Arrays;

public class seqCirQueue<T> implements Queue<T> {

    private final T[] queue; //队列
    private final int length; //数组长度
    private int front; // 前数组
    private int rear; //尾数组

    public seqCirQueue() {
        queue = (T[]) new Object[16];
        length = 16;
        front = rear = 0;
    }

    public seqCirQueue(int length) {
        queue = (T[]) new Object[length];
        this.length = length;
        front = rear = 0;
    }

    @Override
    public void enqueue(T data) {
        if (front == (rear + 1) % length) //如果font == rear +1 那就说明队列已满！
            throw new RuntimeException("queue is full!");
        rear = (rear + 1) % length; //尾指针 + 1
        queue[rear] = data;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is null please add a element!");
        front = (front + 1) % length;
        T temp = queue[front];
        queue[front] = null;
        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is null please add a element!");
        return queue[(front + 1) % length];
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    public int size() {
        return (rear - front + length) % length;
    }

    @Override
    public String toString() {
        return "seqCirQueue{" +
                "queue=" + Arrays.toString(queue) +
                ", length=" + length +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }
}
