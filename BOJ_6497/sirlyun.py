'''
    거지 성진이
    모든 길마다 원래 켜져있던 가로등 중 일부 소등
    길의 가로등을 켜두면 하루에 길의 미터 만큼 돈이 들어가는데, 일부를 소등해 돈 절약
    어떤 두집을 왕래할 때, 불이 켜져있지 않은 길을 지나는건 불가능
    도시에 있는 모든 두 집 쌍에 대해, 불이 켜진 길만으로 서로 왕래할 수 있게 소등 전략
    위의 조건들을 만족하면서 최대로 절약하자 
'''

def find_parent(x):
    if parent[x] != x:
        return find_parent(parent[x])
    
    return parent[x]

def union_parent(a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a > b:
        parent[a] = b
    else:
        parent[b] = a

import sys
input = sys.stdin.readline

while True:
    M, N = map(int, input().split())
    if M == 0 and N == 0:
        break

    costs = []
    for _ in range(N):
        x, y, z = map(int, input().split())
        costs.append((z, x, y))
    costs.sort()
    

    parent = [i for i in range(M)]
    result = 0

    for n in range(N):
        cost, x, y = costs[n]
        if find_parent(x) != find_parent(y):
            union_parent(x, y)
        else:
            result += cost

    print(result)