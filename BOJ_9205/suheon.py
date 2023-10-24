from collections import deque
def bfs(g):
    q = deque()
    q.append(g)
    visited[g] = 1

    while q:
        s = q.popleft()
        for w in range(n+2):
            if arr[s][w] == 0 or visited[w] == 1:
                continue
            q.append(w)
            visited[w] = 1


T = int(input())
for tc in range(1, T + 1):
    n = int(input())

    p = [[0,0] for _ in range(n+2)]

    # 0은 상근이 n+1은 락페스티벌
    for i in range(n+2):
        x,y = map(int, input().split())
        p[i][0] = x
        p[i][1] = y

    arr = [[0] * (n+2) for _ in range(n+2)]

    # 갈 수 있는 곳, 없는 곳 나누기
    for i in range(n+2):
        for j in range(n+2):
            if i == j:
                continue
            if (abs(p[i][0] - p[j][0]) + abs(p[i][1] - p[j][1])) > 1000:
                continue
            arr[i][j] = 1
            arr[i][j] = 1

    # visited[n+1] 1이면 happy 0이면 sad
    visited = [0] * (n+2)
    bfs(0)

    if visited[n+1]:
        print('happy')
    else:
        print('sad')