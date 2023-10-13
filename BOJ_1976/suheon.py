def find_set(x):
    if parents[x] == x:
        return x
    parents[x] = find_set(parents[x])
    return parents[x]

def union(x,y):
    x = find_set(x)
    y = find_set(y)

    if x == y:
        return
    if x < y:
        parents[y] = x
    else:
        parents[x] = y

N = int(input())
M = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
plan = list(map(int, input().split()))

parents = [i for i in range(N)]

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            union(i,j)

ans = 'YES'

temp = 0
for i in range(M):
    p = plan[i] - 1 # 인덱스 맞추기
    a = find_set(p)
    if i == 0:
        temp = a
    else:
        if temp != a:
            ans = 'NO'

print(ans)