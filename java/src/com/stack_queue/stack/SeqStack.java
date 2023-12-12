package com.stack_queue.stack;

import java.io.Serializable;
import java.util.EmptyStackException;


public class SeqStack<T> implements Stack<T>, Serializable {

    private static final long serialVersionUID = -5413303117698554397L;
    // 栈顶指针
    private int top = -1;
    //默认栈容量
    private final int capacity = 10;
    //存放元素的数组
    private T[] array;
    //数组大小
    private int size;

    //构造一个默认为10大小的数组
    public  SeqStack(){
        array = (T[])new Object[this.capacity];
    }

    public SeqStack(int capacity){
        array = (T[]) new Object[capacity];
    }

    /**
     * return Stack size
     * @return Int size
     */
    public int size(){
        return size;
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 添加元素，从栈顶插入
     * @param data
     */
    @Override
    public void push(T data) {
        if (array.length == size) {
            ensureCapacity(size*2+1);
        }
        size++;
        array[++top] = data;

    }

    /**
     * 扩容的方法
     * @param capacity
     */
    public void ensureCapacity(int capacity) {
        //如果需要拓展的容量比现在数组的容量还小,则无需扩容
        if (capacity<size)
            return;

        T[] old = array;
        array = (T[]) new Object[capacity]; //扩容i个大小
        //复制元素
        if (size >= 0) System.arraycopy(old, 0, array, 0, size);
    }


    /**
     * find stack top value
     * @return int top
     */
    @Override
    public T peek() {
        if (isEmpty()) throw  new EmptyStackException();
        return array[top];

    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        size--;
        return array[top--];
    }

}
