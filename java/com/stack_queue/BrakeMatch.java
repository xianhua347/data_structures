package com.stack_queue;

import com.stack_queue.stack.SeqStack;

public class BrakeMatch {
    public static boolean match(String expstr) {
        final SeqStack<Character> stack = new SeqStack<>(expstr.length());  //初始化栈
        for (int i = 0; i < expstr.length(); i++) { //读取每一个字符
            char ch = expstr.charAt(i);
            //如果是左括号入栈
            if ((ch == '(') || (ch == '[')) {
                stack.push(ch);
            } else if (ch == ')') { //右括号出栈
                if (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch == ']') {
                if (!stack.isEmpty() && stack.peek().equals('[')) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "[1*(3+5)/(5/3)]";
        System.out.println(match(str));
    }
}
