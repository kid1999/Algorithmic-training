graph = {
    'A':['B','C'],
    'B':['A','C','D'],
    'C':['A','B','D','E'],
    'D':['B','C','E','F'],
    'E':['C','D'],
    'F':['D']
}

def BFS(graph,s):
    stack = []
    stack.append(s)    #节点栈
    seen = set()        #已输出队列
    seen.add(s)

    while (len(stack) > 0):
        vertex = stack.pop()   #后进先出
        nodes = graph[vertex]
        for w in nodes:
            if w not in seen:
                stack.append(w)
                seen.add(w)
        print(vertex)
    
BFS(graph,'A')

