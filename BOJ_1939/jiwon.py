n, m = map(int,input().split())
arr = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int,input().split()) # a번섬과 b번섬 사이에 중량제한 c인 (양방향)다리 존재
    arr[a].append((b,c))
    arr[b].append((a,c))

start, end = map(int,input().split()) # 공장이 있는 두 섬의 번호
# 공장->공장 이동할 때 다리의 최댓값?

visited = [0]*(n+1)
ans = 0

def dfs(node,cost):
    global ans
    if node == end:
        ans = max(ans, cost)
        return
    visited[node] = 1
    for i, j in arr[node]:
        if not visited[i]:
            dfs(i, j)
    visited[node] = 0
    return
dfs(start,0)
print(ans)