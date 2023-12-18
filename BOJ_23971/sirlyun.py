'''
    거리두기 규칙
        한명씩 앉을 수 있는 테이블이 행마다 W개씩 H행에 걸쳐있다.
        모든 참가자는 세로로 N칸 또는 가로로 M칸 이상 비우고 앉아야함
        최대 몇명을 수용할 수 있을까
'''

import math

H, W, N, M = map(int, input().split())

row = math.ceil(H/(N+1))
col = math.ceil(W/(M+1))

print(row*col)