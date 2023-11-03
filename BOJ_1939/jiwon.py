import sys

input = sys.stdin.readline

def check(weight): # 목적지 도착 여부를 체크하는 함수
    visited = [False] * (n + 1)
    visited[start] = True
    stack = [start]

    while stack:

        current = stack.pop()

        if current == end: # 목적지 도착!
            return True

        for node, bridge_w in arr[current]:
            if bridge_w >= weight and not visited[node]: # 들고온 짐 그대로 건너갈 수 있나?
                visited[node] = True
                stack.append(node)

    return False

n, m = map(int, input().split())
arr = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    arr[a].append((b, c)) # 양방향이므로 둘 다 넣어줌!
    arr[b].append((a, c))

start, end = map(int, input().split())

# 이진탐색 이용
left = 1
right = 1000000000

while left <= right:
    mid = (left + right) // 2

    if check(mid): # 시작지점에서 mid의 중량이 끝까지 도착할 수 있으면?
        left = mid + 1
    else:
        right = mid - 1

print(right)
