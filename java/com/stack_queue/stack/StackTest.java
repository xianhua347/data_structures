package com.stack_queue.stack;

public class StackTest {
    public static void main(String[] args) {
        final LinkedStack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("1");
        linkedStack.push("2");
        linkedStack.push("3");
        System.out.println(linkedStack.peek());
    }
}
