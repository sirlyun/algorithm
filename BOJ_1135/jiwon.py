
def dfs(node, graph):
    if not graph[node]: # 자식 노드가 없는 경우
        return 0
    # 직속 상사의 모든 직속 부하에 대한 거리를 저장
    times = [dfs(child, graph) for child in graph[node]] # 모든 직속 부하들에 대해 반복
    times.sort(reverse=True) # 가장 먼 직속부하가 가장 앞에 오도록 정렬

    max_time = 0
    for i, time in enumerate(times):
        max_time = max(max_time, i + 1 + time) # 현재노드와 사장사이의 거리(+1) 최댓값 갱신

    return max_time # 모든 노드 간 거리 중 가장 긴 거리가 정답임!! = 노드와 사장 사이의 최대 거리

n = int(input())
graph = [[] for _ in range(n)]

for i, num in enumerate(map(int, input().split())):
    if num != -1:
        graph[num].append(i)

print(dfs(0, graph))

