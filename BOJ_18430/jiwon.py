# 다시커밋..

n, m = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]
bum = [(0,-1,1,0),(-1,0,0,-1),(-1,0,0,1),(0,1,1,0)] # 부메랑 4가지 모양
visited = [[0] * m for _ in range(n)]
ans = 0
def dfs(i,j,strength):
    global ans
    if j == m:  # 행을 다 돌았을 때 다음 열로 고.
        i += 1
        j = 0
    if i == n:
        ans = max(ans,strength) # 최댓값 갱신
        return
    if visited[i][j] == 0:
        for k in range(4): # 4가지 모양 가능한지 모두 탐색
            a, b, c, d = bum[k]
            x1,y1,x2,y2 = i+a, j+b, i+c, j+d
            if 0<= x1 <n and 0<= y1 <m and 0<= x2 <n and 0<= y2 <m and visited[x1][y1] == 0 and visited[x2][y2] == 0:
                visited[x1][y1] = visited[x2][y2] = visited[i][j] = 1
                dfs(i,j+1,strength + arr[i][j]*2 + arr[x1][y1] + arr[x2][y2]) # 백트래킹
                visited[x1][y1] = visited[x2][y2] = visited[i][j] = 0
    dfs(i,j+1,strength)

dfs(0,0,0)
print(ans)