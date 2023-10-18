'''
    등산로는 N개의 작은 오두막(노드) N-1개의 오솔길(간선?)으로 이루어져있는 구조
    한 오솔길은 두 개의 오두막을 양 방향으로 연결한다
    오솔길 한개는 길이가 1
    어떤 오두막에서도 다른 모든 오두막으로 하나 이상의 오솔길을 따라 이동하는 것이 가능하다
    오두막들은 1번부터 N번까지 번호가 붙어 있으며, 1번 오두막이 산 정상에 있다
    1번 오두막에서 다른 오두막으로 가는 가장 짧은 길을 따라 가면서 거치는 모든 오솔길들은 항상 산을 내려가는 방향
    철수가 한 오두막에서 다른 오두막으로 갈 때는 항상 산 정상을 거치는 가장 짧은 길을 따라 간다
    이렇게 간 길의 다양성은 길에 포함된 오솔길의 개수로 정의된다. 두 번 이상 지나간 오솔길은 한 번만 센다는 것에 주의하라.
    가능한 i, j의 쌍에 대해서(1 ≤ i < j ≤ N), 철수가 i번 오두막에서 j번 오두막으로 가는 길의 다양성의 총 합을 계산
'''

def cal(n):
    return n*(n-1)//2

def dfs(a, b):
    global result
    group[a] = 1

    for t in tree[a]:
        if t != b:
            group[a] += dfs(t, a)

    if a != 1:
        result += cal(N) - cal(N-group[a])
        
    return group[a]


N = int(input())
tree = [[] for _ in range(N+1)]

for e in range(N-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

group = [0]*(N+1)
result = 0

dfs(1, 0)
print(result)