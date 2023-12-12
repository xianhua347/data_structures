from Node import Node
class csll:
    def __init__(self) -> None:
        self.head = None
        self.size = 0
        self.tail = None

    def append(self, data):
        new_node = Node(data)
        # 如果单链表是空那就把头指针和尾指针指向要插入的node
        if self.tail is None:
            self.head = new_node
            self.tail = self.head
        # 把新元素指向尾指针.next
        self.tail.next = new_node
        # 把self.tail.next也就是新元素的值指向尾指针 这也的话新元素也就链接到了tail上了
        self.tail = self.tail.next
        # 头指针和尾指针相连
        self.tail.next = self.head

    def display(self):
        current = self.head
        while current:
            print(current.data, "data")
            current = current.next
            if current == self.head:
                break


if __name__ == '__main__':
     list= csll()

