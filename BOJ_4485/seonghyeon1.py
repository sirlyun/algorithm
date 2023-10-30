import heapq

def dijk(si,sj) :

    pq = []
    v[si][sj] = arr[si][sj]

    heapq.heappush(pq,(arr[si][sj],si,sj))

    while pq :

        cost,i,j = heapq.heappop(pq)

        if v[i][j] < cost :

            continue

        for di,dj in ((0,1),(0,-1),(1,0),(-1,0)) :

            ni = i + di
            nj = j + dj

            if 0 <= ni < N and 0 <= nj < N :

                new_cost = arr[ni][nj] + cost

                if v[ni][nj] <= new_cost :

                    continue
                
                v[ni][nj] = new_cost
                heapq.heappush(pq,(new_cost,ni,nj))

cnt = 0

while True :

    N = int(input())

    if N == 0 :

        break

    else :

        arr = [list(map(int,input().split())) for _ in range(N)]

        cnt += 1

        INF = int(1e9)

        v = [[INF] * N for _ in range(N)]

        dijk(0,0)

        print(f"Problem {cnt}: {v[N-1][N-1]}")
