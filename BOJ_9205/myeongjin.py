# 맥주 마시면서 걸어가기
from collections import deque


def beer(start):
    q = deque()
    q.append(start)
    visited[start] = 1

    while q:
        t = q.popleft()

        for i in new_arr[t]:
            if visited[i] == 0:
                chk = min_dist(t, i)
                if chk:
                    visited[i] = 1
                    q.append(i)

    if visited[conv_num + 1] == 0:
        print('sad')
    else:
        print('happy')


def min_dist(f, t):
    a, b = home_conv_fest[f]  # 시작하는 곳
    x, y = home_conv_fest[t]

    dist = abs(x - a) + abs(y - b)

    if dist > 1000:
        return 0
    else:
        return 1


T = int(input())
for tc in range(1, T + 1):
    conv_num = int(input())  # 편의점 수
    home_conv_fest = [list(map(int, input().split())) for _ in range(conv_num + 2)]
    home = home_conv_fest[0]
    fest = home_conv_fest[conv_num + 1]

    new_arr = [[] for _ in range(conv_num + 2)]
    for i in range(conv_num + 2):
        for j in range(conv_num + 2):
            if i != j:
                new_arr[i].append(j)

    visited = [0] * (conv_num + 2)
    beer(0)