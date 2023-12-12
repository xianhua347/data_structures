from collections import deque
import networkx as nx
# 简单构造一个图
graph = {}
graph["you"] = ["alice", "bob", "claire"]
graph["bob"] = ["anuj", "peggy"]
graph["alice"] = ["peggy"]
graph["claire"] = ["thom", "jonny"]
graph["anuj"] = []
graph["peggy"] = []
graph["thom"] = []
graph["jonny"] = []
nx.Graph


def search(name):
    search_queue: deque = deque()  # 新建一个队列
    search_queue += graph[name]
    searched = []  # 标记是否查找过
    while search_queue:
        person = search_queue.popleft()  # 弹出元素
        if not person in searched:
            if person_is_seller(person):
                print("is seller")
                return True
            else:
                search_queue += graph[person]
                searched.append(person)
    return False


def person_is_seller(name):
    return name == 'alice'


search('alice')
