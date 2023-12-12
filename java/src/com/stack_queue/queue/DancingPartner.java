package com.stack_queue.queue;

public class DancingPartner {
    public static void match(LinkedQueue<Dancer> q1,LinkedQueue<Dancer> q2, int i){
        int count = 0;
        while (!q1.isEmpty() && !q2.isEmpty()){
            final Dancer dancer1 = q1.dequeue();
            final Dancer dancer2 = q2.dequeue();
            System.out.println(dancer1+"------- "+ dancer2);
            q1.enqueue(dancer1);
            q2.enqueue(dancer2);
            count++;
            if (count == i) break;
        }
    }

    public static void main(String[] args) {
        final LinkedQueue<Dancer> q1 = new LinkedQueue<>();
        final LinkedQueue<Dancer> q2 = new LinkedQueue<>();

        for (int i = 0; i <= 3; i++) {
            final Dancer dancer = new Dancer("Lady" + i, 18);
            q1.enqueue(dancer);
        }
        for (int i = 0; i <= 3; i++) {
            final Dancer dancer = new Dancer("man" + i, 19);
            q2 .enqueue(dancer);
        }
        DancingPartner.match(q1,q2,5);
    }
}
