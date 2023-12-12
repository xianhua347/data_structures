package com.linearList.LinkedList;

import com.linearList.LinearList;

public class SinglyLinkedList<T> implements LinearList<T> {
    //头部指针！
    private Node<T> head;

    public SinglyLinkedList() {
        head = new Node<T>();//构造头部节点
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public SinglyLinkedList(T[] values) {
        this();//调用空参构造
        Node<T> rear = this.head; //头节点给到尾节点
        for (int i = 0; i < values.length; i++) {
            rear.next = new Node<>(values[i], null);
            rear = rear.next;
        }
    }
    @Override
    public T get(int i) {
        int j = 0;
        Node<T> p = this.head.next; //p = 头节点的next指针
        for (i = 0; p != null && j < i; j++) { //遍历链表！ 如果j<i p就移动下标直到 j>i 这就说明可以找到第i个元素
            p = p.next;
        }
        return (i >= 0 && p != null) ? p.data : null;
    }

    @Override
    public void set(int i, T t) {
        int j = 0;
        Node<T> p = this.head.next;
        for (i = 0; p != null && j < i; j++) {
            p = p.next;
        }
        if (i >= 0 && p != null) {
            p.data = t; //将a[i]的数值设置为t
        }
    }

    @Override
    //尾部插入！！
    public int insert(T t) {
        return this.insert(this.size(), t);
    }

    @Override
    public int insert(int i, T t) {
        int j = 0;
        if (t == null) {
            throw new NullPointerException("null pointer!");
        }

        Node<T> newNode = this.head;//指向head节点！
        while (newNode.next != null && j < i) { //寻找i的前一个节点
            newNode = newNode.next;
            j++;
        }

        if (newNode != null && j == i) {//找到i前面的一个节点
            Node<T> s = new Node<T>(t, newNode.next);
            newNode.next = s;
            return i;
        } else {
            return -1;
        }
    }

    @Override
    public T remove(int i) {
        int j = 0;
        Node<T> p = this.head;
        while (p.next != null && j < i) { //寻找i-1的节点
            p = p.next;
            j++;
        }
        if (p.next != null && j == i) {// i节点存在
            T old = p.next.data;//保存待删除节点的数据源
            p.next = p.next.next;//删除节点

            return old;//返回已删除的数据
        } else {
            return null;
        }
    }

    @Override
    public boolean contains(T key) {
        return indexOf(key) != -1;
    }

    @Override
    public int indexOf(T key) {
        int i = 0;
        Node<T> p = this.head.next;
        for (; p != null; p = p.next) {
            if (p.data.equals(key)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public int size() {
        int n = 0;
        Node<T> p = this.head.next;
        while (p != null) {
            n++;//计数器++
            p = p.next; //p下标＋1
        }
        return n; //返回长度！
    }

    @Override
    public void clear() {
        this.head.next = null;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public void printList() {
        Node<T> p = this.head.next;
        while (p != null) {
            System.out.println(p.data);
            p = p.next; //next指针下移
        }
    }
    /**
     * @param head
     * @param index
     * @return lastNode
     */
    //查找最后第i个节点
    public Node<T> findLastIndexNode(Node<T> head, int index){
        if (head ==null) {
            throw new NullPointerException("没有数据!");//如果头为就抛出异常！
        }
        final int size = size();//得到size

        //数据校验！
        if (index<=0 ||index >size) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        Node<T> temp = this.head.next; //获取第一个数据
        //遍历数组 只要list总长度小于Index就继续循环！ eg: size 3 index 1 循环两次 就可以找到最后一个元素
        for (int i = 0; i <size-index ; i++) {
            temp= temp.next; //移动下标
        }
        return temp;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.insert("张三");
        list.insert("李四");
        list.insert("王五");
        list.insert("赵四");
        final Node<String> lastIndexNode = list.findLastIndexNode(list.getHead(), 2);//获得最后i个数据
        System.out.println(lastIndexNode);

    }
}
