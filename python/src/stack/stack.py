# 使用单链表实现stack LIFO

class Node:
    def __init__(self, data=None) -> None:
        self.data = data
        self.next = None


class Stack:
    def __init__(self) -> None:
        self.head = Node(data="hello")
        self.size = 0

    def __str__(self) -> str:
        cur = self.head.next
        out = ""
        while cur:
            out += str(cur.data) + "->"
            cur = cur.next
        return out

    def get_size(self):
        return self.size

    def isEmpty(self):
        return self.size == 0

    # 查看栈顶元素
    def peek(self):
        if self.isEmpty():
            raise Exception("STACK IS NULL BRO")
        # 取出栈顶元素
        return self.head.next.data

    # 压栈
    def push(self, data):
        new_node = Node(data=data)
        # 把新节点和栈顶元素连接起来
        new_node.next = self.head.next
        # 把头节点 next 赋值给新节点 形成压栈
        self.head.next = new_node

        self.size += 1

    # 栈顶弹出元素
    def pop(self):
        if self.isEmpty():
            raise Exception("STACK IS NULL BRO")
        # 保存需要清除的元素
        remove = self.head.next
        # 把栈顶元素清除 举个例子 当前栈顶是元素是9再往前下个元素是8 
        # 我们只要把栈顶的下一个值赋值 栈顶 那就可以实现弹出操作 
        # 因为这样就是覆盖了栈顶的值后面的元素不会变
        self.head.next = self.head.next.next
        # size -1
        self.size -= 1
        return remove.data


if __name__ == "__main__":
    stack = Stack()
    for i in range(1, 11):
        stack.push(i)
    print(f"Stack: {stack}")

    for _ in range(1, 6):
        remove = stack.pop()
        print(f"Pop: {remove}")
    print(f"Stack: {stack}")
