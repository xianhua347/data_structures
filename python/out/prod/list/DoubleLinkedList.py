import gc


class Node:
    def __init__(self, prev=None, data=None, next=None) -> None:
        self.prev = prev  # 前驱节点
        self.data = data  # 数据
        self.next = next  # 后继结点


class DoublyLinkedList:
    def __init__(self) -> None:
        self.head = None

    # 在链表头部添加节点
        # 构造新元素
    def push(self, data):
        new_node = Node(data=data)
        # 把头部指针指向new_node.next
        new_node.next = self.head
        # 把new_data.prev设置为None 因为是头插
        new_node.prev = None
        # 如果当前头节点不为空，则将其prev指针指向新节点
        if self.head is not None:
            self.head.prev = new_node
        # 设置头节点为new_node
        self.head = new_node

    def insertBefore(self, next_node, data) -> None:
        if (data is None):
            raise ValueError("data can not be NULL")

        # 2. allocate new node
        # 3. put in the data
        new_node = Node(data=data)
        new_node.prev = next_node.prev
        next_node.prev = new_node
        new_node.next = next_node

        if new_node.prev:
            new_node.prev.next = new_node
        self.head = new_node

    # 在指定元素之后插入
    def insert_after(self, prev_node, data) -> None:
        if (data is None):
            raise ValueError("data can not be NULL")

        # 2. allocate new node
        # 3. put in the data
        new_node = Node(data=data)
        # 4. Make next of new node as next of prev node
        new_node.next = prev_node.next
        # 5. Make prev_node as previous of new_node
        prev_node.next = new_node
        # 6. Make prev_node ass previous of new_node
        new_node.prev = prev_node
        # 7. Change previous of new_nodes's next node
        if new_node.next:
            new_node.next.prev = new_node

    def insert(self, data, position):
        new_node = Node(data=data)
        # 如果是在头部插入
        if position == 0:
            new_node.next = self.head
            if self.head:
                self.head.prev = new_node
            self.head = new_node
            return

        # 如果不是在头部插入 循环到指定位置
        current_node = self.head
        for i in range(position - 1):
            if current_node is None:
                raise Exception("position out of range")
            current_node = current_node.next

        # 新节点next指针指向当且节点的下一个节点
        new_node.next = current_node.next
        # 新节点prev指针指向当前
        new_node.prev = current_node
        # 如果当前节点的下一个节点不为空
        if current_node.next:
            # 将当前节点的下一个prev 指向新节点
            current_node.prev = new_node
        # 将当前节点的next指向新节点
        # 完成在指定位置插入操作
        current_node.next = new_node

    def append(self, data):
        new_node = Node(data=data)
        last = self.head
        # new_node是链表的最后一个元素所以把后继节点设置为None
        new_node.next = None
        # 如果头部节点为空那就说明没有元素 那就把new_node设置头节点
        if self.head is None:
            new_node.prev = None
            self.head = new_node
            return
        # 循环到链表的最后一个元素
        while last.next:
            last = last.next
        # 把last的后继节点指向new_node前驱节点
        last.next = new_node.prev
        # 把new_node的前驱节点指向last
        # 这样new_node就是最后一个元素了
        new_node.prev = last

    def isEmpty(self) -> bool:
        return self.head is None if True else False

    def clean(self):
        current_node = self.head.next
        self.head = self.head.next
        self.head.next = current_node.next
        gc.collect()

    def delete_node(self, node: Node):

        if self.head is None or node is None:
            raise ValueError("data or list head can not be NULL")

        # 检查是否是头部节点
        if self.head == node:
            self.head = node.next
        # 检查是否有后继节点 如果有，则将后继节点的 prev 指针指向要删除节点的前驱节点。
        if node.next:
            node.next.perv = node.prev
        # 检查是否有后继节点 如果有，则将前驱节点的 next 指针指向要删除节点的后继节点。
        if node.prev:
            node.prev.next = node.next
        # 释放内存
        gc.collect()

    # 删除指定的元素
    def delete_at_position(self, position):
        temp = self.head
        # 遍历全部元素
        while temp:
            if temp.data == position:
                break
            temp = temp.next
        if temp == None:
            raise BaseException("can't found v")
        self.deleteNode(node=temp)

    # 更新指定元素的值

    def update_at_position(self, position, data):
        if self.head is None:
            raise Exception("List is Empty")
        current_node = self.head
        # 便利到指定位置每次便利都会移动头指针从而可以可以找到对应Node
        # 最后做更新操作
        for i in range(position):
            if current_node is None:
                raise Exception("position out of range")
            current_node = current_node.next
            current_node.data = data

    # 获取双链表长度
    def length(self) -> int:
        count = 0
        current_node = self.head
        while current_node:
            count = count + 1
            current_node = current_node.next
        return count

    def search(self, key) -> bool:
        temp = self.head
        while temp:
            if temp == key:
                return True
            temp = temp.next
        return False


    def reverse(self):
        prev = None
        current = self.head
        while current:
            next = current.next
            current.next = prev
            prev = current
            current = next
        self.head = prev

    def print_list(self, node):
        while node:
            print(node.data),
            last = node
            node = node.next

    def print_list(self):
        last = self.head
        while last:
            print(last.data)
            last = last.next


if __name__ == '__main__':
    dllist = DoublyLinkedList()
    dllist.insert(1, 0)
    dllist.insert(2, 1)
    dllist.insert(3, 2)
    dllist.reverse()
    dllist.print_list()
