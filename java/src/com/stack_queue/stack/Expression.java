package com.stack_queue.stack;

import java.util.HashMap;
import java.util.Map;

public class Expression {

    public static String inFixPostfix(String infix){
        final SeqStack<String> stack = new SeqStack<>(infix.length()); //初始化存放运算符
        final StringBuffer postfix = new StringBuffer(); //存放后缀表达式

        for (int i = 0; i < infix.length(); i++) {

            final char charAt = infix.charAt(i);
            switch (charAt){
                case '(': //进栈
                    stack.push(charAt+"");
                    break;

                case ')' : //出栈
                    String str = null;
                    while(!(str = stack.pop()).equals("(")) postfix.append(str);
                    break;

                case '+': //只有 + - 才会进栈
                case '-':
                    while(!stack.isEmpty() && !stack.peek().equals("(")) postfix.append(stack.pop());
                    stack.push(charAt + "");
                    break;

                case '*':
                case'/':
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/")) ) postfix.append(stack.pop());
                    stack.push(charAt + "");
                    break;

                default:
                    stack.push(String.valueOf(charAt));
            }

            while (!stack.isEmpty()) postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static float calculate(String postfix){
        final LinkedStack<Float> linkedStack = new LinkedStack<>();
        float res = 0;
        for (int i = 0; i<postfix.length();i++){
            char ch = postfix.charAt(i); //读取数子
            if (Character.isDigit(ch)){ //如果是数字
                linkedStack.push(Float.parseFloat(ch+ "")); //压到栈
            }else{
                //如果是运算符
                float num1 = linkedStack.pop();
                float num2 = linkedStack.pop();
                switch (ch){
                    case '+': res = num1+num2; break;
                    case '-': res = num1-num2; break;
                    case '*': res = num1*num2; break;
                    case '/': res = num1/num2; break;
                }
                linkedStack.push(res);
            }
        }
        return linkedStack.pop();
    }

    public static void main(String[] args) {
        String infix = "(1+2*4)-5";
        System.out.println(calculate(inFixPostfix(infix)));
    }
}
