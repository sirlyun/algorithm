
def solution(n, wires): # 송전탑의 개수 n, 전선 정보 wires

    def find(x,parent):     # 부모 찾기
        if parent[x] < 0:
            return x
        parent[x] = find(parent[x],parent)
        return parent[x]

    def union(x, y,parent):  # 합침
        x = find(x,parent)
        y = find(y,parent)
        if x == y:
            return -1
        if parent[x] < parent[y]:
            parent[x] += parent[y]
            parent[y] = x
        elif parent[x] > parent[y]:
            parent[y] += parent[x]
            parent[x] = y
        else:
            parent[y] += parent[x]
            parent[x] = y
        return 1

    answer = n
    for i in range(len(wires)):
        parent = [-1]*(n+1)

        for a,b in (wires[:i] + wires[i+1:]):
            union(a,b,parent)

        group1 = parent[find(wires[i][0],parent)]
        group2 = parent[find(wires[i][1],parent)]
        answer = min(answer, abs(group1-group2))
    return answer

print(solution(9,[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]))