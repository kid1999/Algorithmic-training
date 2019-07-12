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

    while (len(quenue) > 0):
        vertex = quenue.pop(0)
        nodes = graph[vertex]
        for w in nodes:
            if w not in seen:
                quenue.append(w)
                seen.add(w)
        print(vertex)
    
BFS(graph,'A')

