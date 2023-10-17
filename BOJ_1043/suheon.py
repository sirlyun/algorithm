'''
1. 서로소 집합으로 다 만든다. (부모 == 작은 수)
2. know_true를 순회하면서 요소들의 가장 상위 부모를 know_true에 append한다.
3. 1 ~ N+1까지 순회하면서 know_true에 속해있지 않고, 부모가 know_true에 속해있는 요소들을 know_true에 append한다.
4. 파티를 순회하면서 know_true의 요소가 없는 파티의 숫자를 센다.
'''

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

N, M = map(int ,input().split()) # 사람 수, 파티의 수

# 진실을 아는 사람의 수와 번호
know_true = list(map(int, input().split()))
know_true.pop(0)
# 각 파티마다 오는 사람의 수와 번호
party = []
for _ in range(M):
    arr = list(map(int, input().split()))
    arr.pop(0)
    party.append(arr)

parents = [i for i in range(N+1)]

# Union
for a in party:
    for i in range(1,len(a)):
        if find_set(a[i]) != find_set(a[i-1]): # 사이클 방지
            union(a[i], a[i-1])

cnt = 0

# know_true의 가장 상위 부모를 아는 사람으로 만든다.
for i in know_true:
    if parents[i] not in know_true:
        know_true.append(parents[i])

# 사람들을 돌면서 부모가 아는 사람이면 아는 사람으로 만든다.
for i in range(1,N+1):
    if i not in know_true:
        if parents[i] in know_true:
            know_true.append(i)

for a in party:
    for i in a:
        if parents[i] in know_true:
            break
    else:
        cnt += 1
print(cnt)