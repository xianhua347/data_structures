package com.linearList.DoubleLinkedList;

import com.linearList.LinearList;

import java.util.List;

public class DoubleLinkedList<T> implements LinearList<T> {
    private final DoubleNode<T> head;

    //默认构造一个头节点
    public DoubleLinkedList() {
        head = new DoubleNode<T>();
    }

    //参数构造
    public DoubleLinkedList(T[] values){
        this();//调用默认构造 构造一个头节点
        DoubleNode<T> rear = head; //尾节点
        for (int i = 0; i < values.length; i++) {      //循环有多个节点 接着初始化节点
            DoubleNode<T> node = new DoubleNode<>(values[i],rear,rear.next);    //构造一个包含前驱后驱 的节点
            rear.next = node; //移动后驱
            rear = node;
        }
    }

    //获取第i个节点
    private DoubleNode<T> getNode(int i){
        int j = 0;
        DoubleNode<T> temp = head.next; //使用temp存储链表的第一个值
        for (;temp != null && j<i;j++){     //使用循环试图找到第i个元素 如果j<i那就说明 i还未找到 那就移动next直到找到元素为止！
            temp = temp.next;
        }
        return (i>=0 && temp!= null) ?temp :null;
    }

    @Override
    //获取指定元素的值
    public T get(int i) {
        DoubleNode<T> temp = getNode(i);
        return temp != null?temp.data:null;
    }

    @Override
    public void set(int i, T t) {
        DoubleNode<T> temp = getNode(i); //找到指定节点
        if (temp != null){ //判断temp里面有元素！
            temp.data = t; //设置i节点的data域为t
        }
    }

    @Override
    public int insert(T t) {
        return this.insert(size(),t); //尾部插入！
    }

    @Override
    public int insert(int i, T t) {
        DoubleNode<T> temp = getNode(i-1); //找到i的上一个节点！
        temp = (i == 0)? head :temp; //判读i的上一个节点是否==0

        if (temp != null){
            DoubleNode<T> node = new DoubleNode<>(t,temp,temp.next);//插入元素！data：T prev:temp next：temp.next
            temp.next = temp; //移动
            if (node.next != null) node.next.prev = node;
            return i; //返回受影响的元素！
        }
        return -1;//如果没有找到返回 -1
    }

    @Override
    public T remove(int i) {
        DoubleNode<T> temp = getNode(i); //获取要删除的节点
        if (temp != null){
            T old = temp.data;
            temp.prev.prev = temp.next;
            if (temp.next != null){
                temp.next.prev = temp.prev;
                return old;
            }
        }
        return null;
    }

    @Override
    public boolean contains(T key) {
        return indexOf(key) == -1; //调用indexof方法判断是否有指定元素
    }

    @Override
    //找到指定元素的下标
    public int indexOf(T key) {
        int j = 0;
        DoubleNode<T> temp= head.next;
        while(temp!=null){
            if(temp.data.equals(key)){
                return j;
            }
            j++;
            temp=temp.next;
        }
        return -1; //找不到元素
    }

    @Override
    public int size() {
        int n = 0; //计数器
        DoubleNode<T> temp = this.head.next;
        while(temp!=null){
            n++; //计数器+1
            temp = temp.next; //next下移
        }
        return n;
    }

    @Override
    public void clear() {
        this.head.next =null; //next域设置为null 链表会断开
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public void printList() {
        DoubleNode<T> temp = this.head.next;
        while(temp!= null){
            System.out.println(temp.data+" ");
            temp = temp.next; //移动next域
        }
    }
}
