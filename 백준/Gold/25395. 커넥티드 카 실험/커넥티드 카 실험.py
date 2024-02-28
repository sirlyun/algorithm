from collections import deque

class Car:
    def __init__(self, idx, locate, fuel):
        self.idx = idx
        self.locate = locate
        self.fuel = fuel


N, S = map(int, input().split())

arr = []

tmp1 = list(map(int, input().split()))
tmp2 = list(map(int, input().split()))

for i in range(N):
    arr.append(Car(i+1, tmp1[i], tmp2[i]))

q = deque()
visit = [False] * (N + 1)

q.append(arr[S - 1])
visit[S] = True


while q:
    cur = q.popleft()
    cur_idx = cur.idx

    for i in range(cur_idx - 1, -1, -1):
        if arr[i].locate < cur.locate - cur.fuel:
            break

        if visit[arr[i].idx]:
            continue

        q.append(arr[i])
        visit[arr[i].idx] = True

    for i in range(cur_idx, N):
        if arr[i].locate > cur.locate + cur.fuel:
            break

        if visit[arr[i].idx]:
            continue

        q.append(arr[i])
        visit[arr[i].idx] = True

result = []

for i in range(1, N + 1):
    if visit[i]:
        result.append(str(i))

print(" ".join(result))
