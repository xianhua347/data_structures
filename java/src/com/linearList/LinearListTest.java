package com.linearList;

import com.linearList.DoubleLinkedList.DoubleLinkedList;

public class LinearListTest {

    public static void main(String[] args) {
        Integer[] num =new Integer[]{1,2,3,4};
        final DoubleLinkedList<Object> list = new DoubleLinkedList<>(num);
        list.printList();
        list.clear();
        System.out.println(list.isEmpty());
    }
}
