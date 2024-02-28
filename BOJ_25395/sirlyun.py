'''
    기능
        사물 인터넷에 연결된 커넥티드 카 원격 조종
        연결된 카와 연결 안된 카가 같은 위치에 있으면
        연결 안된 카를 연결시킬 수 있다.
        그렇게 연결하면 계속 연결 상태가 유지된다.
    
    실험을 위해 1부터 N까지 번호가 매겨진 카를 일렬로 배치
    i번 카의 초기 위치는 xi, 연료량 hi
    카는 1만큼의 연료를 소비해서 1의 거리만큼 이동
    연료를 모두 소비하면 움직일 수 없다
    
    처음에는 모두 비연결 상태
    S번 카를 먼저 연결하고, 기능을 활용해서 연결 전파
    여러 조합을 활용해서 연결 가능성이 있는 카들의 번호를 모두 구하기

    연결될 가능성이 있는 모든 카의 번호를 오름차순으로 정렬하여 출력한다.
'''

from collections import deque

class Car:
    def __init__(self, idx, locate, fuel):
        self.idx = idx
        self.locate = locate
        self.fuel = fuel

    def __lt__(self, other):
        return self.locate < other.locate

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

arr.sort()

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
