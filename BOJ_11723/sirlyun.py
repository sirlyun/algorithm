'''
    add x : S에 x를 추가, 이미 S에 x가 있는 경우 연산 무시
    remove x : S에서 x를 제거, 이미 S에 x가 없는 경우 연산 무시
    check x : S에 x가 있으면 1, 없으면 0 출력
    toggle x : S에 x가 있으면 x를 제거하고, 없으면 x를 추가
    all : S를 {1, 2, ..., 20} 으로 바꾸기
    empty : S를 공집합으로 초기화
'''

import sys

# 연산 개수
M = int(sys.stdin.readline())
S = set()

for _ in range(M):
    tmp = list(sys.stdin.readline().split())
    
    if len(tmp) == 1:
        if tmp[0] == "all":
            S = set([i for i in range(1, 21)])
        else:
            S.clear()
    
    else:
        cal, x = tmp[0], tmp[1]
        x = int(x)

        if cal == "add":
            S.add(x)
        elif cal == "remove":
            S.discard(x)
        elif cal == "check":
            if x in S:
                print(1)
            else:
                print(0)
        elif cal == "toggle":
            if x in S:
                S.discard(x)
            else:
                S.add(x)