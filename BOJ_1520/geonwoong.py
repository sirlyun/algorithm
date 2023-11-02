N, M = map(int, input().split())
mat = [list(map(int, input().split())) for _ in range(N)]
visited = [[-1] * M for _ in range(N)]
delta = [[1, 0], [0, 1], [-1, 0], [0, -1]]

def dfs(i, j):
    if i == N-1 and j == M-1:
        return 1

    if visited[i][j] != -1:
        return visited[i][j]

    visited[i][j] = 0

    for di, dj in delta:
        ni, nj = i + di, j + dj
        if 0 <= ni < N and 0 <= nj < M and mat[i][j] > mat[ni][nj]:
            visited[i][j] += dfs(ni, nj)

    return visited[i][j]

print(dfs(0, 0))