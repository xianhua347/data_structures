package com.linearList.stack_queue.queue;


/**
 * 约瑟夫环
 */
public class JosephusRing {
    /**
     * @param n  numbers
     * @param m = target
     *
     */
    public void outQueue(int n, int m) {
        final LinkedQueue<Integer> ring = new LinkedQueue<>(); //使用linked queue构造一个环
        int count = 0; //计数器

        for (int i = 0; i < n; i++) ring.enqueue(i);   //元素全部入队
        while (!ring.isEmpty()) {   //队列不等于null
            final Integer dequeue = ring.dequeue();     //全部出队
            count++;
            if (count == m) {    //如果等于目标数 打印数字
                System.out.println(dequeue + "出队");
                count =0;
            }else ring.enqueue(dequeue);    //入队
        }
    }
}
