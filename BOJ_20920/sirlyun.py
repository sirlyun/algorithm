'''
    1. 자주 나오는 단어일수록 앞에 배치
    2. 해당 단어의 길이가 길수록 앞에 배치
    3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치

    길이가 M이상인 단어들만 외움
'''

import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
word = {}
for i in range(N):
    chk = input().rstrip()
    if len(chk) < M:
        continue
    else:
        word.setdefault(chk, 0)
        word[chk] += 1

result = sorted(word.items(), key=lambda x : (-x[1], -len(x[0]), x[0]))
for w in result:
    print(w[0])