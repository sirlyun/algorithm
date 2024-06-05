'''
    D 킬로미터 길이의 고속도로를 지난다
    모든 지름길은 일방통행, 고속도로 역주행 불가
    운전해야 하는 거리의 최솟값은?
'''

import heapq

def dijkstra(start):
    queue = []
    heapq.heappush(queue, [0, start])
    distance[start] = 0

    while queue:
        dist, now = heapq.heappop(queue)

        if dist > distance[now]:
            continue

        for r in road[now]:
            cost = dist + r[1]
            if cost < distance[r[0]]:
                distance[r[0]] = cost
                heapq.heappush(queue, [cost, r[0]])

N, D = map(int, input().split())
distance = [1e9]*(D+1)
road = [[] for _ in range(D+1)]

for d in range(D):
    road[d].append([d+1, 1])
for n in range(N):
    start, end, length = map(int, input().split())
    if end > D:
        continue
    road[start].append([end, length])

dijkstra(0)
print(distance[D])