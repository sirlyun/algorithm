'''
    메모장에 쓰여진 키워드 총 N개
    새로운 글을 작성할 때, 최대 10개의 키워드에 대해 글 작성
    글에 사용된 키워드는 메모장에서 사라짐

    메모장에 남은 키워드는 몇 개?
'''

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
keyword_dict = {}
result = 0

for n in range(N):
    keyword_dict[input().rstrip()] = 1
    result += 1

for m in range(M):
    writing = input().rstrip().split(',')
    for keyword in writing:
        if keyword in keyword_dict.keys() and keyword_dict[keyword] == 1:
            keyword_dict[keyword] = 0
            result -= 1
    print(result)