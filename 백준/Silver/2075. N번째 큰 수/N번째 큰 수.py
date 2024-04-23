'''
    NxN의 표에 수 N^2개가 채워짐
    모든 수는 자신의 한칸 위에 있는 수보다 크다
'''

import heapq

N = int(input())
result_list = []
for n in range(N):
    for num in list(map(int, input().split())):
        if len(result_list) != N:
            heapq.heappush(result_list, num)
            continue
        if num > result_list[0]:
            heapq.heappop(result_list)
            heapq.heappush(result_list, num)
print(result_list[0])