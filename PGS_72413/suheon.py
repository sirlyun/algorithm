'''
다익스트라 for i -> 1~n
i to A,B,S 비용 계산 최소값
'''

import heapq

def solution(n, s, a, b, fares):
    # 인접 리스트
    adj_lst = [[] for _ in range(n + 1)]
    for f, t, fare in fares:
        adj_lst[f].append([fare, t])
        adj_lst[t].append([fare, f])

    def dijk(i):
        # 누적 합 배열 -> for문 돌릴 때마다 초기화
        cc = [INF] * (n + 1)  # 0번째는 생각안함
        pq = []
        heapq.heappush(pq, (0, i))
        cc[i] = 0

        while pq:

            cost, x = heapq.heappop(pq)

            if cc[x] < cost:
                continue

            for c, y in adj_lst[x]:
                new_cost = c + cost

                if cc[y] <= new_cost:
                    continue

                cc[y] = new_cost
                heapq.heappush(pq, (new_cost, y))

        # i to A,B,S 합 반환
        return cc[a] + cc[b] + cc[s]

    INF = int(1e9)
    min_v = INF
    for i in range(1, n + 1):
        x = dijk(i)
        if min_v > x:
            min_v = x

    return min_v