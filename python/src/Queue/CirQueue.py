# 实现循环队列
# 1.队列特点 FIFO(first in first out)
# 2.元素个数是n - 1
# 3.只能从尾部插入和从头部弹出
# 4.它是一种受约束的线性表
# 5.解决队列假溢出问题 解决方法保留一个空间 当队列头和队列尾差一 为满 公式为(tail +1) % maxsize == head

from typing import Optional


class CirQueue:

    def __init__(self) -> None:
        self.queue = []
        self.len = 16
        self.head = 0
        self.tail = 0

    def __init__(self, len) -> None:
        self.queue = [None] * len
        self.len = len
        self.head = 0
        self.tail = 0

    def enqueue(self, data: str) -> bool:
        #判断队列是否满了
        if self.isFull():
            return False

        # 从尾指针插入
        self.tail = (self.tail + 1) % self.len  # 尾指针+1 eg：3+1 % 16 = 2
        self.queue[self.tail] = data  # 入队列
        return True

    def dequeue(self) -> bool:
        #判断队列是否为空
        if self.isEmpty():
            return False
        self.head = (self.head + 1) % self.len  # 找到队列的第一个元素 第一个元素在头指针+1的位置
        self.queue[self.head] = None  # 出队列
        return True

    def peek(self) -> Optional[str]:
        return self.queue[(self.head + 1) % self.len]  # 找到头元素

    def isEmpty(self) -> bool:
        return self.head == self.tail

    def size(self) -> int:
        size = (self.tail - self.head - self.len) % self.len
        return size

    def isFull(self):
        return (self.tail + 1) % self.len == self.head


if __name__ == '__main__':
    cirQueue = CirQueue(3)
    cirQueue.enqueue('new world')
    cirQueue.enqueue('hjkhjk')
    cirQueue.enqueue('new')
    print(cirQueue.isFull())
