'''
다익스트라
'''
import heapq


def dijk(si,sj):
    # 우선순위 큐
    pq = []
    # 출발점 누적 합
    mm[si][sj] = arr[si][sj]
    heapq.heappush(pq, (mm[si][sj],si,sj))

    while pq:
        s, i, j = heapq.heappop(pq)

        if mm[i][j] < s:
            continue

        for di, dj in [[0,1],[1,0],[0,-1],[-1,0]]:
            ni = i+di
            nj = j+dj
            # 범위
            if ni < 0 or N <= ni or nj < 0 or N <= nj:
                continue

            new_cost = s + arr[ni][nj]

            if mm[ni][nj] <= new_cost:
                continue
            mm[ni][nj] = new_cost
            heapq.heappush(pq, (new_cost,ni,nj))


# 테스트 케이스 끝이 0이다
T = 1
while True:
    N = int(input())
    # 테스트 케이스 끝
    if N == 0:
        break
    arr = [list(map(int ,input().split())) for _ in range(N)]

    # 다익스트라 초기 설정 -> 최소 누적합 배열
    INF = int(1e9)
    mm = [[INF] * N for _ in range(N)]

    # 0,0 출발
    dijk(0,0)

    print(f'Problem {T}: {mm[N-1][N-1]}')
    T += 1