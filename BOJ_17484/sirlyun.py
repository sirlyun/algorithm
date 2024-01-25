def dfs(start, depth, cnt, pre_direct):
    global result

    if depth == N-1:
        result = min(result, cnt)
    
    for i in range(3):
        if i != pre_direct:
            di = start[0] + 1
            dj = start[1] + dy[i]
            if 0<=di<N and 0<=dj<M:
                visited[di][dj] = True
                dfs((di, dj), depth+1, cnt+arr[di][dj], i)
                visited[di][dj] = False
            


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[False]*M for _ in range(N)]
dy = [-1, 0, 1]
dy_visited = [False]*3
result = 1e9
for j in range(M):
    dfs((0, j), 0, arr[0][j], 3)

print(result)