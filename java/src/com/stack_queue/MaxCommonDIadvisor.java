package com.stack_queue;

public class MaxCommonDIadvisor {
    public static int fun(int a, int b) {
        if (b <= a && b == 0)
            return a;
        else if (a < b)
            return fun(b, a);
        else
            return fun(b, a % b);
    }
}
