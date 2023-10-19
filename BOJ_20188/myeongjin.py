from collections import deque


def go(num): # 가는 경우의 수
    result = []
    for i in range(1, num):
        for j in range(num+1):
            if i < j:
                result.append((i, j))
    return result


def bfs(x, y): # x에서 y로
    if x == 1:
        visited = [0] * (N+1)
        q = deque()
        q.append(x)

        while q:
            t = q.popleft()

            for i in new_arr[t]:
                if visited[i] == 0:
                    visited[i] = visited[t] + 1
                    q.append(i)

                if i == y:
                    break

        return visited[y]

    else:
        lst = [(1, x), (1, y), (x, y)]
        cnt = 0
        for a, b in lst:

            visited = [0] * (N + 1)
            q = deque()
            q.append(a)

            while q:
                t = q.popleft()

                for i in new_arr[t]:
                    if visited[i] == 0:
                        visited[i] = visited[t] + 1
                        q.append(i)

                    if a == 1 and i == b:
                        break
                    if a == x and i == b:
                        break

            cnt += visited[b]

        return cnt//2


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N-1)]

new_arr = [[] for _ in range(N+1)]
for i, j in arr:
    new_arr[i].append(j)
    new_arr[j].append(i)

from_to = go(N)
cnt = 0
for a, b in from_to:
    result = bfs(a, b)
    cnt += result
print(cnt)