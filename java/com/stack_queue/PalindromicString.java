package com.stack_queue;

public class PalindromicString {
    public static boolean isPalindromic(String string){
        int length = string.length();
        for (int i = 0; i < length / 2; i++) {
            if (string.toCharArray()[i]!= string.toCharArray()[length -i -1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromic("abceba"));
    }
}
