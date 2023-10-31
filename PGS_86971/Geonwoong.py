from collections import deque

def solution(n, wires):
    answer = 100
    
    # 연결되어 있는 송전탑 표시
    graph = [[0]*(n+1) for _ in range(n+1)]
    for idx in wires:
        graph[idx[0]][idx[1]], graph[idx[1]][idx[0]] = 1, 1
    
    # 선 하나씩 끊어보면서 BFS
    for idx in wires:
        graph[idx[0]][idx[1]], graph[idx[1]][idx[0]] = 0, 0
        queue = deque()
        visited = [0] * (n+1)
        lst = []
        for i in range(1, n+1):
            if visited[i] == 0:
                queue.append(i)
                visited[i] = 1
                cnt = 1
                while queue:
                    r = queue.popleft()
                    for j in range(n+1):
                        if graph[r][j] == 1 and visited[j] == 0:
                            queue.append(j)
                            visited[j] = 1
                            cnt += 1
                lst.append(cnt)

        # 최솟값 업데이트       
        if answer > abs(lst[0] - lst[1]):
            answer = abs(lst[0] - lst[1])
        
        # 끊은 거 다시 연결
        graph[idx[0]][idx[1]], graph[idx[1]][idx[0]] = 1, 1


    return answer