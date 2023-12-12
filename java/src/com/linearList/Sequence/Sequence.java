package com.linearList.Sequence;

import com.linearList.LinearList;

/**
 * @author 33891
 */
public class Sequence<T> implements LinearList<T> {
    private T[] data; //数据元素
    private int n; //线性表大小

    /**
     * 空参构造函数 默认线性表大小为10
     */
    //默认空参构造
    public Sequence() {
        this(10);
    }

    /**
     * 创建一个指定长度大小的线性表
     * @param length 线性表长度
     */
    //创建一个length长度的数组
    public Sequence(int length) {
        this.data = (T[]) new Object[length];

    }

    /**
     * 创建一个由特定数据元素组成的线性表
     * @param values 数据元素
     */
    //由values数组构造
    public Sequence(T[] values) {
        this(values.length);
        for (int i = 0; i < values.length; i++) {
            this.data[i] = values[i];
        }
        this.n = values.length;
    }

    /**
     * 获得指定的元素
     * @param i 下标值
     * @return 元素
     */
    @Override
    public T get(int i) {
        if (i >= 0 && i <= this.n) {
            return this.data[i];
        } else {
            throw new IndexOutOfBoundsException("index of out bounds");
        }
    }

    /**
     * 在指定的位置插入一个值
     * @param i  下标
     * @param data 数据
     */
    @Override
    public void set(int i, T data) {
        if (data == null){
            throw new NullPointerException("null");
        }
        if (i>=0 && i<=this.n){
            this.data[i] = data;
        }else {
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    @Override
    public int insert(T o) {
        //调用本类方法
        return this.insert(this.n, o);
    }

    @Override
    public int insert(int index, T data) {
        if (data == null) {
            throw new NullPointerException("null point");
        }
        //判断下标是否合法
        if (index >= 0 && index <= this.n) {
            //复制data到一个数组里面
            Object[] src = this.data;
            if (this.n == this.data.length) {
                this.data = (T[]) new Object[src.length * 2];
                System.arraycopy(src, 0, this.data, 0, index);
            }

            for (int i = this.n; i> index;i--){
                this.data[i] = this.data[i-1];
            }
            // 插入
            this.data[index] = data;
            // 长度增加
            this.n++;
            return index;
        } else {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
    }

    @Override
    public T remove(int i) {
        if (this.n == 0) {
            try {
                throw new Exception("null pointer");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (i >= 0 && i < this.n) {
            T old = this.data[i];
            if (this.n - 1 - i >= 0) {
                System.arraycopy(this.data, i + 1, this.data, i, this.n - 1 - i);
            }
            this.data[this.n - 1] = null;
            this.n--;
            return old;
        } else {
            throw new IndexOutOfBoundsException("index out of bands!");
        }
    }

    @Override
    public boolean contains(T key) {
        for (int i = 0; i <= this.n; i++) {
            if (key.equals(this.data[n])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T key) {
        for (int i = 0; i <= this.n; i++) {
            if (key.equals(this.data[n])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.n;
    }

    @Override
    public void clear() {
        this.n = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.n == 0;
    }

    @Override
    public void printList() {
        for (int i = 0; i <= this.n; i++) {
            System.out.println(this.data[i]);
        }
    }

    public static void main(String[] args) {
         Sequence<String> arraySequence = new Sequence<>();
        arraySequence.set(0,"hello");
        arraySequence.insert("say");



        System.out.println("arraySequence.get(0) = " + arraySequence.get(0));
        System.out.println("arraySequence.contains(\"hello\") = " + arraySequence.contains("hello"));
        System.out.println("arraySequence.contains(\"hello\") = " + arraySequence.indexOf("hello"));
        arraySequence.printList();
    }
}
