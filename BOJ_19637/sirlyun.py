'''
    전투력에 칭호를 부여한다.
    칭호마다 기준 숫자가 있고 해당 숫자보다 더 커야 칭호를 얻는다.
    여러 개의 칭호가 가능한 경우 가장 먼저 입력된 칭호가 최종이다.
    
    가장 높은 칭호의 전투력 기준보다 큰 전투력을 가지지는 못한다.
    입력 조건이 매우 커 이분 탐색
'''

def binary_search(check, level):
    left = 0
    right = len(level) - 1
    result = 0

    while left <= right:
        mid = (left + right) // 2

        if int(level[mid][1]) >= check:
            # 더 먼저 입력된 칭호가 최종이 될 수 있도록 앞으로 이동
            right = mid - 1
            result = mid
        # 칭호를 얻기 위한 점수보다 큰 전투력을 가지면 더 높은 칭호를 탐색 
        else:
            left = mid + 1
    
    return result

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
level = [input().split() for _ in range(N)]

for m in range(M):
    check = int(input())
    print(level[binary_search(check, level)][0])