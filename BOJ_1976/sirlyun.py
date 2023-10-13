'''
    한국에는 도시 N개가 있고 도시 간에 길이 있을 수도 없을 수도?
    이 여행 계획이 가능한지 체크
    i번째 줄의 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미한다. 1이면 연결된 것이고 0이면 연결이 되지 않은 것이다. 
'''

def bfs(start, end):
    queue = []
    queue.append(start)
    visited = [False]*N
    visited[start] = True

    while queue:
        now = queue.pop(0)

        if now == end:
            return True

        
        for n in range(N):
            if graph[now][n] == 1:
                if not visited[n]:
                    visited[n] = True
                    queue.append(n)


    return False



N = int(input())
M = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
plan = list(map(int, input().split()))

for p in range(1, M):
    if not bfs(plan[p-1]-1, plan[p]-1):
        print('NO')
        break
else:
    print('YES')