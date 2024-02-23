'''
    삼각형 모양의 현수막 제작
    현수막을 걸 수 있는 지면에는 N개의 말뚝이 한줄로 박혀있다.
    M개의 깃대 중 하나를 이용해 현수막을 건다.
    1. 말뚝 중 두개를 골라 두 말뚝 사이 공간이 밑변이 되도록 한다.
    2. 깃대를 골라 말뚝 사이 중앙에 깃대의 길이가 현수막의 높이가 되도록
        삼각형 모양으로 현수막을 건다.
    예산 최대로 살 수 있는 현수막의 최대 넓이 R
    구매해서 걸 수 있는 현수막 넓이의 최댓값 구하기
'''

def solution():
    tmp_list = set()
    for i in range(N-1):
        for j in range(i+1, N):
            base = abs(wood_list[i] - wood_list[j])
            tmp_list.add(base)

    make_triangle(sorted(tmp_list))

    return


def make_triangle(tmp_list):
    global result

    for i in range(M):
        left = 0
        right = len(tmp_list) - 1

        while left <= right:
            mid = (left + right) // 2
            if tmp_list[mid] * poll_list[i] <= 2 * R:
                result = max(result, tmp_list[mid] * poll_list[i])
                left += 1
            else:
                right -= 1
    return

import sys
input = sys.stdin.readline

N, M, R = map(int, input().split())
wood_list = list(map(int, input().split()))
poll_list = list(map(int, input().split()))
result = -1e9

solution()
if result == -1e9:
    print(-1)
else:
    print(result / 2)