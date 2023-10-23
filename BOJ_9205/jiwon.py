from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    q=deque([(h_i,h_j)])
    while q:
        i, j = q.popleft()  # 현재위치
        if abs(f_i-i) + abs(f_j-j) <= 1000: # 현재위치에서 페스티벌까지 거리
            return 'happy'
        else:
            for p in range(n):
                if abs(p_lst[p][0]-i) + abs(p_lst[p][1]-j) <= 1000 and visited[p]==0:
                    q.append((p_lst[p][0],p_lst[p][1]))
                    visited[p] = 1
    return 'sad'

T = int(input())
for _ in range(T):
    n = int(input()) # 편의점 개수
    h_i, h_j = map(int,input().split()) # 집 좌표
    p_lst = []  # 편의점 리스트
    for _ in range(n):  # 편의점들 좌표 받기
        p_i, p_j = map(int,input().split())
        p_lst.append((p_i,p_j))
    f_i, f_j = map(int,input().split())  # 페스티벌 좌표
    visited = [0]*(n+1)
    print(bfs())