'''
    N개의 알파벳 대문자가 써있는 종이
    종이에서 네 개의 문자를 골라 그 문자들을 제외한 나머지 문자를 전부 지웠을 때 "DKSH"가 되도록 한다
    네 개의 문자를 고르는 방법의 수를 구한다
'''

import sys

input = sys.stdin.readline

N = int(input())
S = input()

d, k, s, h = 0, 0, 0, 0

for i in range(N):
    if S[i] == 'D':
        d += 1
    elif S[i] == 'K':
        k += d
    elif S[i] == 'S':
        s += k
    elif S[i] == 'H':
        h += s

print(h)