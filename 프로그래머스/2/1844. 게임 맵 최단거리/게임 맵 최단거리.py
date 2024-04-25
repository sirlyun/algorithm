'''
    캐릭터는 동, 서, 남, 북 방향으로 한 칸씩 이동 가능
    0은 벽이 있는 자리
    1은 벽이 없는 자리
    초기 설정
        캐릭터는 왼쪽 상단
        상대방은 우측 하단
'''

from collections import deque

def bfs(maps):
    N = len(maps)
    M = len(maps[0])
    visited = [[-1]*M for _ in range(N)]
    check = deque()
    check.append([0, 0])
    visited[0][0] = 1
    
    while check:
        now_i, now_j = check.popleft()
        for dx, dy in [(-1, 0), (0, -1), (1, 0), (0, 1)]:
            di = now_i + dx
            dj = now_j + dy
            if 0<=di<N and 0<=dj<M and maps[di][dj] and visited[di][dj] == -1:
                visited[di][dj] = visited[now_i][now_j] + 1
                check.append([di, dj])
    
    return visited[N-1][M-1]

def solution(maps):
    answer = 0
    
    answer = bfs(maps)
    
    return answer