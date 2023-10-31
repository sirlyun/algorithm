
import heapq
import sys
input = sys.stdin.readline

cnt = 0
inf = int(1e9)

while True:
    n = int(input())

    if n == 0:
        break

    cnt += 1
    arr = [list(map(int,input().split())) for _ in range(n)]
    q = []
    v = [[inf] * n for _ in range(n)]
    v[0][0] = 0
    heapq.heappush(q,(arr[0][0],0,0))

    while q:
        c, i, j = heapq.heappop(q)
        for ti, tj in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
            ni, nj = i + ti, j + tj
            if 0 <= ni < n and 0 <= nj < n:
                cost = c + arr[ni][nj]
                if v[ni][nj] > cost:
                    v[ni][nj] = cost
                    heapq.heappush(q,(cost,ni, nj))

    print(f'Problem {cnt}: {v[n-1][n-1]}')