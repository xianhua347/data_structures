from typing import re, Optional
""" 
数组实现队列
可视化:
 https://www.cs.usfca.edu/~galles/visualization/QueueArray.html
"""
class ArrayQueue:
    def __init__(self,size:int) -> None:
        self.queue = [None] * size
        self.size = size
        self.head = 0
        self.tail = 0
        
    def enqueue(self,item) -> bool:
        if self.tail == self.size:
            if self.head == 0:
                raise False
            else:
                for i in range(0,self.tail - self.head):
                    self.queue[i] = self.queue[i+self.head]
                self.tail = self.tail - self.head
                self.head = 0
        self.queue.insert(self.tail,item)
        self.tail += 1
        return True
    
    # 出队操作
    def dequeue(self)-> Optional[object]:
        #如果队列没有满
        if self.head != self.tail:
            #找到队列头
            item = self.queue[self.head]
            #头指针+1实现出栈
            self.head += 1
            #返回出栈元素
            return item
        else:
            return None
        
if __name__ == '__main__':
    aq = ArrayQueue(20)
    aq.enqueue("nihao ")
    aq.enqueue("rr")
    aq.dequeue()