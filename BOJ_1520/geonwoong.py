from collections import deque
N, M = map(int, input().split())
mat = [list(map(int, input().split())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
delta = [[1, 0], [0, 1], [-1, 0], [0, -1]]

queue = deque()
queue.append((0, 0))
visited[0][0] = 1
while queue:
    r, c = queue.popleft()
    for dr, dc in delta:
        nr, nc = r + dr, c + dc
        if 0 <= nr < N and 0 <= nc < M and mat[r][c] > mat[nr][nc] and (r, c) != (N, M):
            queue.append((nr, nc))
            visited[nr][nc] += 1

print(visited[N-1][M-1])