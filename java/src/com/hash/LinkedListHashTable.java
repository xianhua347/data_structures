package com.hash;

import com.linearList.LinkedList.SinglyLinkedList;

import javax.print.attribute.HashAttributeSet;
import java.util.stream.IntStream;

/**
 * @author 33891
 */
public class LinkedListHashTable {
    private SinglyLinkedList[] singlyLinkedList;

    private final int tableSize;

    public LinkedListHashTable(int tableSize) {
        this.singlyLinkedList = new SinglyLinkedList[tableSize];
        this.tableSize = tableSize;
        IntStream.range(0, singlyLinkedList.length).forEach(i -> this.singlyLinkedList[i] = new SinglyLinkedList());
    }

    //构造哈希函数使用key % 哈希表大小
    private int hashFun(int key) {
        return key % tableSize;
    }

    private void insert(int key,Student student){
        int index = hashFun(key);
        this.singlyLinkedList[index].insert(student);
    }

    public void list(){
        IntStream.range(0,singlyLinkedList.length).forEach(e-> System.out.println(singlyLinkedList[e].getHead()));
    }

    public static void main(String[] args) {
        LinkedListHashTable hashTable = new LinkedListHashTable(10);
        hashTable.insert(1,new Student(1,"FJSDKLJFSD"));
        hashTable.insert(2,new Student(3,"JEWRKLJKWLE"));
        hashTable.list();
    }
}
class Student{
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
