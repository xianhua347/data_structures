from list.Node import Node


class LikedQueue:
    def __init__(self) -> None:
        self.head: Node = None
        self.tail: Node = None

    def enqueue(self, data):
        new_node = Node(data)
        if self.tail:  # 如果尾节点不为空
            self.tail.next = new_node
        else:  # 如果tail节点为空那就说明 队列为空 那就把头节点和尾节点设置为new_node
            self.head = new_node
        self.tail = new_node  # 进队列

    def dequeue(self):
        if self.head:
            data = self.head.data
            self.head = self.head.next  # 出队列
            if not self.head:  # 如果head为空那就说明这个队列只剩一个tail元素
                self.tail = None
            return data


if __name__ == '__main__':
    lq = LikedQueue()
    lq.enqueue("hello")
    lq.enqueue("world")
    lq.dequeue()
