from collections import deque


def bfs(start, arr, n):  # 시작지점, 그래프, 노드 수
    q = deque()
    q.append(start)
    visited = [0] * (n+1)
    visited[start] = 1

    while q:  # BFS 방문
        t = q.pop()

        for i in arr[t]:
            if visited[i] == 0:
                q.append(i)
                visited[i] = 1

    ans = abs(2 * visited.count(1) - n)  # 차이

    return ans


def solution(n, wires):

    new_arr = [[] for _ in range(n + 1)]
    for i, j in wires:
        new_arr[i].append(j)
        new_arr[j].append(i)

    min_ans = 1e9
    for k in range(n-1):
        x, y = wires[k]  # 줄 1개 끊기
        new_arr[x].remove(y)
        new_arr[y].remove(x)

        result = bfs(x, new_arr, n)
        min_ans = min(result, min_ans)  # 최소 차이 갱신

        new_arr[x].append(y) # 줄 다시 잇기
        new_arr[y].append(x)

    return min_ans
