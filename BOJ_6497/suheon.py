import sys

def find(k):
    # k의 부모 찾기
    # 부모의 부모를 찾자
    if parents[k] != k:
        return find(parents[k])
    # 이미 부모가 자신이면 (다 찾음)
    return parents[k] # 어쨌든 k임

# 작은 값이 부모
def union(a,b):
    a = find(a)
    b = find(b)

    if a == b: # 사이클
        return

    if a < b:
        parents[b] = a
    else:
        parents[a] = b

while True:
    m,n = map(int, sys.stdin.readline().split()) # 집의 수(노드), 길의 수(간선)
    if m == 0 and n == 0:
        break
    edge = []

    cost = 0

    for _ in range(n):
        x,y,z = map(int, sys.stdin.readline().split()) # x <-> y / z미터
        edge.append([z,x,y])
        cost += z
    # 0,0 처리

    edge.sort()

    parents = [i for i in range(m)]


    cnt = 0

    for z,x,y in edge:
        if find(x) != find(y): # 싸이클 발생 안하면
            cnt += 1
            cost -= z
            union(x,y)
            if cnt == m:
                break

    print(cost)