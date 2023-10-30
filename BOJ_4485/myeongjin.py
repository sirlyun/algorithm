'''
00 -> N-1 N-1로 가는데
행렬의 수만큼 소지금을 잃게 된다.
최소 금액 구하기
'''
import heapq as hq


def dijkstra(i, j): # 다익스트라

    heap = []
    hq.heappush(heap, (arr[0][0], i, j)) # 첫 소지금, 위치
    loss_list[i][j] = arr[0][0] # 소지금 갱신

    while heap:
        w, x, y = hq.heappop(heap) # 소지금, 위치

        for k in range(4):
            ci, cj = x+di[k], y+dj[k] # 상하좌우 확인

            if 0 <= ci < N and 0 <= cj < N: # 행렬 안에 있으면,
                loss = w + arr[ci][cj] # 누적 소지금

                if loss_list[ci][cj] > loss: # 최소 소지금
                    loss_list[ci][cj] = loss
                    hq.heappush(heap, (loss, ci, cj))


cnt = 0
while True:
    cnt += 1
    N = int(input())
    if N == 0: # 0이면 바로 끝내
        break
    arr = [list(map(int, input().split())) for _ in range(N)]
    di = [-1, 1, 0, 0]
    dj = [0, 0, -1, 1]
    loss_list = [[1e9] * N for _ in range(N)] # 최소 소지금
    dijkstra(0, 0)
    print(f'Problem {cnt}: {loss_list[N-1][N-1]}')
