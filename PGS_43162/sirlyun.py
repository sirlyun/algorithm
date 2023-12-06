def solution(n, computers):
    parent = [i for i in range(n)]
    
    def find_parent(x):
        if parent[x] != x:
            return find_parent(parent[x])

        return x

    def connect(x, y):
        a = find_parent(x)
        b = find_parent(y)

        if a < b:
            parent[b] = a
        else:
            parent[a] = b

    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1:
                connect(i, j)
    
    group = set()
    for i in range(n):
        group.add(find_parent(i))
            
    return len(group)