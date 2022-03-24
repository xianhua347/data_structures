package com.linearList.Sequence;

import com.linearList.LinearList;

public class Sequence<T> implements LinearList<T> {
    private T[] data;
    private int n;

    //默认空参构造
    public Sequence() {
        this(10);
    }

    //创建一个length长度的数组
    public Sequence(int length) {
        this.data = (T[]) new Object[length];
    }

    //由values数组构造！
    public Sequence(T[] values) {
        this(values.length);
        for (int i = 0; i < values.length; i++) this.data[i] = values[i];
        this.n = values.length;
    }

    @Override
    public T get(int i) {
        if (i > 0 && i < this.n) {
            return this.data[i];
        } else {
            throw new IndexOutOfBoundsException("index of out bounds");
        }
    }

    @Override
    public void set(int i, T o) {
        if (o != null) {
            if (i >= 0 && i < this.n) this.data[i] = o;
            else throw new IndexOutOfBoundsException("index of out bounds!");
        } else throw new NullPointerException("null!");
    }

    @Override
    public int insert(T o) {
        //调用本类方法
        return this.insert(this.n, o);
    }

    @Override
    public int insert(int i, T o) {
        if (o == null) throw new NullPointerException("null point");
        if (i > 0 && i < this.n) {
            Object[] src = this.data;
            if (this.n == data.length) {
                this.data = (T[]) new Object[src.length * 2];
                System.arraycopy(src, 0, this.data, 0, i);
            }
            for (int j = this.n - 1; j >= i; j++) {
                this.data[i] = o;
                this.n++;
                return i;
            }
        } else {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        return 0;
    }

    @Override
    public T remove(int i) {
        if (this.n == 0) {
            try {
                throw new Exception("null poninter");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (i >= 0 && i < this.n) {
            T old = this.data[i];
            if (this.n - 1 - i >= 0) System.arraycopy(this.data, i + 1, this.data, i, this.n - 1 - i);
            this.data[this.n - 1] = null;
            this.n--;
            return old;
        } else {
            throw new IndexOutOfBoundsException("index out of bands!");
        }
    }

    @Override
    public boolean contains(Object key) {
        for (int i = 0; i < this.n; i++) if (key.equals(this.data[n])) return true;
        return false;
    }

    @Override
    public int indexOf(Object key) {
        for (int i = 0; i < this.n; i++) if (key.equals(this.data[n])) return i;
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
        for (int i = 0; i < this.n; i++) System.out.println(this.data[i]);
    }

    public static void main(String[] args) {
         Sequence<String> arraySequence = new Sequence<>();
        arraySequence.set(0,"CHEN");
    }
}
