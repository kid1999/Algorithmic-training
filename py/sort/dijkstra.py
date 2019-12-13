import math,heapq

graph = {
    'A':{'B':5,'C':1},
    'B':{'A':5,'C':2,'D':1},
    'C':{'A':1,'B':2,'D':4,'E':8},
    'D':{'B':1,'C':4,'E':3,'F':6},
    'E':{'C':8,'D':3},
    'F':{'D':6}
}

# 初始化 距离
def init_distance(graph,s):
    distance = {s:0}
    for vertex in graph:
        if vertex !=s:
            distance[vertex] = math.inf
    return distance

def Dijkstra(graph,s):
    pquenue = []
    heapq.heappush(pquenue,(0,s))   #优先队列入队
    seen = set()        #已输出队列
    seen.add(s)
    #这两个一起表示 某节点的父节点及其距离
    parents = {s:None}  #父节点字典
    distance = init_distance(graph,s)   #初始化距离 最大值

    while (len(pquenue) > 0):
        pair = heapq.heappop(pquenue)   #优先队列出队
        dist = pair[0]
        vertex = pair[1]
        seen.add(vertex)        #此时才确定该节点已经被读取
        nodes = graph[vertex].keys()
        for w in nodes:
            if w not in seen:
                if dist + graph[vertex][w] < distance[w]:   #如果更新的距离小于原来的距离
                    heapq.heappush(pquenue,(dist + graph[vertex][w],w))   #入队
                    # 修改父节点字典
                    parents[w] = vertex         
                    distance[w] = dist + graph[vertex][w]
    return parents,distance

# 搜寻 V 到 A 的最短路径
parents , distances = Dijkstra(graph,'A')  
print(parents)
print(distances)

