import math

class twoStacks:
    def __init__(self, n: int) -> None:
        self.size: int = n
        self.arr = [None] * n
        self.top1 = math.floor(n / 2) + 1
        self.top2 = math.floor(n / 2)

    def push1(self, data):
        # 至少有一个空间存放元素
        if self.top1 > 0:
            # top自减1 eg top 6 -> 5
            self.top1 = self.top1 - 1
            # data把put到数组里面
            self.arr[self.top1] = data
        else:
            raise Exception("arr out of size")

    def push2(self, data):
        if self.top2 < self.top1 - 1:
            self.top2 = self.top2 + 1
            self.arr[self.top2] = data
        else:
            raise Exception("arr out of size")

    def pop1(self):
        if self.pop1 <= self.size / 2:
            pop = self.arr[self.pop1]
            self.top1 = self.top1 + 1
            return pop
        else:
            print("Stack Overflow by element : ")

    def pop2(self):
        # top2 >= top1
        if self.top2 >= math.floor(self.size / 2) + 1:
            pop = self.arr[self.top2]
            # 自减一
            self.top2 = self.top2 - 1
            return pop
        else:
            print("Stack Underflow")
            exit(1)


if __name__ == '__main__':
    st = twoStacks(n=10)
    st.push2(1)
    st.push2(2)
    st.pop2()
