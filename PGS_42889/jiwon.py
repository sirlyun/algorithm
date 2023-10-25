import sys
import heapq

input = sys.stdin.readline
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)] # [거리, 연료의 양]
town, fuel = map(int, input().split())
cnt = 0
arr.append([town, 0])  # 맨 뒤에 추가(도착지점)
arr.sort()  # 주유소 거리순 정렬
heap = []

for i in range(n+1):
    if fuel - arr[i][0] < 0: # 현재 연료로 가장 가까운 주유소까지 가지 못함
        while heap:
            fuel += -heapq.heappop(heap) # 힙에 있는 연료를 높은 순으로 넣어줌
            cnt += 1 # 충전 횟수 증가
            if fuel - arr[i][0] >= 0:
                break
    if len(heap) == 0 and fuel - arr[i][0] < 0:  # 충전할 주유소가 없고 가장 가까운 주유소까지 가지 못함
        cnt = -1  # 실패!
        break
    else:  # 뒤에 충전할 주유소가 있고 가장 가까운 주유소까지 갈 수 있음
        heapq.heappush(heap, -arr[i][1])  # 힙에 연료가 높은걸 우선순위로 해서서넣어줌

print(cnt)