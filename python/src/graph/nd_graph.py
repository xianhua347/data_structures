class Graph:
    ver_list: list = []  # 顶点的值
    edges = [[]]  # 边
    edges_sum: int  # 边 总数

    def __init__(self, n: int):
        self.ver_list = n
        self.edges = 0

    def insert_ver_list(self, var):
        self.ver_list.append(var)

    def insert_edge(self, v1: int, v2: int, weight: int):
        self.edges[v1][v2] = weight
        self.edges[v2][v1] = weight
        self.edges_sum = self.edges_sum + 1

    def get_edges_sum(self):
        return self.edges_sum

    def get_value_by_id(self, n: int):
        return self.ver_list.pop(n)

    def get_wight(self,v1:int,v2:int):
        return self.edges[v1] [v2]

    def print(self):
        for index in self.edges:
            print(index)


if __name__ == '__main__':
    g=Graph(5)
    g.insert_ver_list("A")
    g.insert_ver_list("B")
    g.insert_ver_list("C")
    g.insert_ver_list("D")