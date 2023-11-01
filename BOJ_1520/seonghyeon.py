def dfs(i,j) :

    if i == N - 1 and j == M - 1 :

        return 1

    if visit[i][j] != -1 :

        return visit[i][j]

    visit[i][j] = 0

    for di, dj in ((1,0),(-1,0),(0,1),(0,-1)) :

        ni = i + di
        nj = j + dj

        if 0 <= ni < N and 0 <= nj < M and arr[ni][nj] < arr[i][j] :

            visit[i][j] += dfs(ni,nj)

    return visit[i][j]

N,M = map(int,input().split())

arr = [list(map(int,input().split())) for _ in range(N)]

visit = [[-1] * M for _ in range(N)]

print(dfs(0,0))