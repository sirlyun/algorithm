from collections import deque

def bfs(start, end):
    q = deque()
    if start == 0:
        q.append(1)
    else:
        q.append(start)
    
    while q:
        p = q.popleft()
        
        if p == end: # 도착하면 시간 반환
            return timeline[p]
        
        for i in (p-1, p+1, p*2):
            if 0 <= i < 100001 and timeline[i] == 0:
                if i == p*2: # 시간 +0 (순간이동)
                    timeline[i] = timeline[p]
                    q.appendleft(i) # 우선 순위
                else: # 시간 +1 (걷기)
                    timeline[i] = timeline[p] + 1
                    q.append(i)
    

N, K = map(int, input().split())
# idx : 위치 / value : 시간
timeline = [0] * 100001

if N == 0: # 1부터 시작
    print(bfs(N, K) + 1)
else:
    print(bfs(N, K))