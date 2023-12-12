package com.linearList;

public interface LinearList<T> {
     T get(int i );
     void set(int i,T t);
     int insert(T t);
     int insert(int i,T t);
     T remove(int i);
    boolean contains(T key);
    int indexOf(T key);
    int size();
    void clear();
    boolean isEmpty();
    void printList();
}
