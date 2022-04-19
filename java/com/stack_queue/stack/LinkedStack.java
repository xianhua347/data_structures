package com.stack_queue.stack;


public class LinkedStack<T> implements Stack<T>{

    private LinkedNode<T> top;

    public LinkedStack(){
        top = null;
    }


    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(T data) {
        LinkedNode<T> linkedNode = new LinkedNode<>(data);
        linkedNode.setNext(top); //设置新节点指针指向top top = null 然后 top节点会指向新节点 这时候 top元素就是新加入的节点
        top = linkedNode; //设置top指针指向新元素节点
    }

    @Override
    public T peek() {
        if (this.isEmpty()) throw new RuntimeException("Stack is null please push a value");
        return top.getData();
    }

    @Override
    public T pop() {
        if (this.isEmpty()) throw new RuntimeException("Stack is null please push a value");
        T topData  = top.getData(); //取出元素
        top = top.getNext(); //top节点指向下一个节点
        return  topData; //返回删除的值
    }

}


