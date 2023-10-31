
import heapq
import sys
input = sys.stdin.readline

cnt = 0 # 테스트케이스
inf = int(1e9)  # 임의의 아주 큰 수

while True:
    n = int(input())

    if n == 0:  # 0입력시 끝냄
        break

    cnt += 1    # 몇 번째 테스트케이스인지 누적
    arr = [list(map(int,input().split())) for _ in range(n)]
    q = []
    v = [[inf] * n for _ in range(n)]
    v[0][0] = 0
    heapq.heappush(q,(arr[0][0],0,0))

    while q:
        c, i, j = heapq.heappop(q) # 누적된 도둑루피, 현재의 열과 행
        for ti, tj in [(1, 0), (-1, 0), (0, 1), (0, -1)]:   # 4방향 탐색
            ni, nj = i + ti, j + tj
            if 0 <= ni < n and 0 <= nj < n:
                cost = c + arr[ni][nj]
                if v[ni][nj] > cost:    # 최솟값을 찾아야 하므로 더 작은 값을 갱신
                    v[ni][nj] = cost
                    heapq.heappush(q,(cost,ni, nj))
                    # 더 작은 경로가 아니라면 볼 필요도 없으니 인큐도 하지 않음!

    print(f'Problem {cnt}: {v[n-1][n-1]}')  # 도착지점에 있을 때 최소도둑루피(n,n)