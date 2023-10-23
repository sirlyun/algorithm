from collections import deque

T = int(input())

for tc in range(1,T+1) :

    n = int(input())
    locations = [list(map(int,input().split())) for _ in range(n+2)]
    graph = [[0] * (n+2) for _ in range(n+2)]
    visit = [0] * (n+2)

    for i in range(n+2) :

        for j in range(i+1, n+2) :

            if abs(locations[i][0] - locations[j][0]) + abs(locations[i][1] - locations[j][1]) <= 1000 :

                graph[i][j] = graph[j][i] = 1

    q = deque([0])

    while q :

        now = q.popleft()

        if now == n+1 :

            print('happy')
            break

        for i in range(n+2) :

            if visit[i] == 0 and graph[now][i] == 1 :

                q.append(i)
                visit[i] = 1

    else : print('sad')