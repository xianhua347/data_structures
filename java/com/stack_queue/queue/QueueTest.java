package com.stack_queue.queue;

public class QueueTest {
    public static void main(String[] args) {
        /*final seqCirQueue<String> seqQueue = new seqCirQueue<>(3);
        seqQueue.enqueue("chen");
        seqQueue.enqueue("xian");
        System.out.println(seqQueue.peek());
        System.out.println("size is $" + seqQueue.size());
        System.out.println(seqQueue);*/
        final LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        System.out.println(linkedQueue.length());
    }
}
