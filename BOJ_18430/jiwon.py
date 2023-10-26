n, m = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]
bum = [[(0,-1),(1,0)],[(0,-1),(-1,0)],[(-1,0),(0,1)],[(0,1),(1,0)]]

max_strength = 0
visited = [[0] * m for _ in range(n)]

def dfs(i,j,strength):
    global max_strength
    max_strength = max(strength, max_strength)
    if visited[i][j] == 1:
        return
    else:
        for k in range(4):
            flag = 0
            for h in range(2):
                if 0 <= i + bum[k][h][0] < n and 0 <= j + bum[k][h][1] < m:
                    if visited[i + bum[k][h][0]][j + bum[k][h][1]] == 1:
                        flag = -1
            if flag == 0:
                    # 백트래킹...?
                    visited[i + bum[k][0][0]][j + bum[k][0][1]] = 1
                    visited[i + bum[k][1][0]][j + bum[k][1][1]] = 1
                    dfs(i,j,strength + arr[i][j]*2 + arr[i + bum[k][0][0]][j + bum[k][0][1]]+arr[i + bum[k][1][0]][j + bum[k][1][1]])
                    visited[i + bum[k][0][0]][j + bum[k][0][1]] = 0
                    visited[i + bum[k][1][0]][j + bum[k][1][1]] = 0

# 중심위치 정하기(i,j)
for i in range(n):
    for j in range(m):
        dfs(i,j,0)