
m, n = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(m)]
visited = [[0]*n for _ in range(m)]
cnt = 0
def bfs(i,j):
    global cnt
    if i == m - 1 and j == n - 1:
        cnt += 1
        return
    if visited[i][j] == 0:
        for ti, tj in [(0,1),(0,-1),(1,0),(-1,0)]:
            ni, nj = i+ti, j+tj
            if 0 <= ni < m and 0 <= nj < n  and arr[i][j] > arr[ni][nj] and not visited[ni][nj]:
                visited[ni][nj] = 1
                bfs(ni,nj)
                visited[ni][nj] = 0
    return
bfs(0,0)
print(cnt)