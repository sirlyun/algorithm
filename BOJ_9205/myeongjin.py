# 맥주 마시면서 걸어가기
from collections import deque


def beer(start):
    q = deque()
    q.append(start)
    visited[start] = 1 # 시작지점 방문

    while q: # bfs로 갈 수 있는 곳을 다 찾는데,
        t = q.popleft()

        for i in new_arr[t]:
            if visited[i] == 0:
                chk = min_dist(t, i) # 맥주거리가 1000 초과면 못 가고, 이하면 간다.
                if chk: # 통과하면 방문
                    visited[i] = 1
                    q.append(i)

    if visited[conv_num + 1] == 0:
        print('sad')
    else:
        print('happy')


def min_dist(f, t): # index 0 : home / index end : fest
    a, b = home_conv_fest[f] # 시작 지점
    x, y = home_conv_fest[t] # 끝 지점

    dist = abs(x - a) + abs(y - b) # 거리 탐색

    if dist > 1000: # 1000 초과 : False
        return 0
    else:           # 1000 이하 : True
        return 1


T = int(input())
for tc in range(1, T + 1):
    conv_num = int(input())  # 편의점 수
    home_conv_fest = [list(map(int, input().split())) for _ in range(conv_num + 2)]

    new_arr = [[] for _ in range(conv_num + 2)] # 서로 다 연결되어 있다고 가정한다.
    for i in range(conv_num + 2):
        for j in range(conv_num + 2):
            if i != j:
                new_arr[i].append(j)

    visited = [0] * (conv_num + 2) # 방문하는 곳
    beer(0)