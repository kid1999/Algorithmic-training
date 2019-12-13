graph = {
    'A':['B','C'],
    'B':['A','C','D'],
    'C':['A','B','D','E'],
    'D':['B','C','E','F'],
    'E':['C','D'],
    'F':['D']
}

def BFS(graph,s):
    quenue = []
    quenue.append(s)    #节点队列
    seen = set()        #已输出队列
    seen.add(s)
    parents = {s:None}  #父节点字典

    while (len(quenue) > 0):
        vertex = quenue.pop(0)
        nodes = graph[vertex]
        for w in nodes:
            if w not in seen:
                quenue.append(w)
                seen.add(w)
                parents[w] = vertex
        # print(vertex)
    return parents

# 搜寻 V 到 A 的最短路径
parent = BFS(graph,'A')
v = 'E'
while v != None:
    print(v)
    v = parent[v]

