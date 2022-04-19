package com.stack_queue;

import java.util.HashMap;

/**
 * 斐波那契数列 改进版 使用map增加执行效率
 */
public class Recursive {

    public static int fib(int n) {
        final HashMap<Integer, Integer> hashMap = new HashMap<>();
        if (n < 0) throw new IndexOutOfBoundsException("index of out of bounds");
        if (n == 1 || n == 2) return 1;     //递归边界
        int num = fib(n - 1) + fib(n - 2);  //递归
        hashMap.put(n, num);
        return num;
    }

    public static int sum(int n) {
        if (n == 1) return 1; //递归边界
        else return n + sum(n - 1); //递归
    }

    public static void main(String[] args) {
        int arr[]={1,2,4,6,7};
        printStr(arr,arr[0], arr[4]);
    }
    public static void printStr(int[] arr,int start,int end){
        System.out.println(arr[start]);
        printStr(arr,start,end);
    }

}
