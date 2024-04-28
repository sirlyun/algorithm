'''
    모든 지점에 대해서 목표 지점까지의 거리 구하기
    오직 평행으로만 움직일 수 있음
    지도의 크기는 NxM
    0은 갈 수 없는 땅, 1은 갈 수 있는 땅, 2는 목표지점
'''

from collections import deque

def bfs(start):
    result = [[-1]*M for _ in range(N)]
    check = deque()
    check.append(start)
    result[start[0]][start[1]] = 0

    for n in range(N):
        for m in range(M):
            if map_list[n][m] == 0:
                result[n][m] = 0

    while check:
        now_i, now_j = check.popleft()

        for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            di = now_i + dx
            dj = now_j + dy
            # 범위 내에 있으면서 방문한 적 없는 장소
            if 0<=di<N and 0<=dj<M and result[di][dj] == -1 and map_list[di][dj] == 1:
                result[di][dj] = result[now_i][now_j] + 1
                check.append([di, dj])

    return result

N, M = map(int, input().split())
map_list = []
start = []
for n in range(N):
    tmp = list(map(int, input().split()))
    for m in range(M):
        if tmp[m] == 2:
            start = [n, m]
    map_list.append(tmp)

result = bfs(start)
for n in range(N):
    for m in range(M):
        print(result[n][m], end=' ')
    print()