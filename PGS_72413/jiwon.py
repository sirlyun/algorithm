import heapq
INF = int(1e9)

def dijkstra(n, graph, s):  # 출발지점 s
    distance = [INF] * (n + 1)  # 최단거리만 계속 갱신해서 저장하는 리스트
    distance[s] = 0
    q = []
    heapq.heappush(q, (0, s))  # (거리, 노드번호)

    while q:
        dist, now = heapq.heappop(q)  # 가장 거리가 짧은 노드 꺼내기

        if distance[now] < dist:  # 이미 처리되었으면 무시
            continue
        for node in graph[now]:
            cost = distance[now] + node[1]  # 현재까지의 거리 + 가중치 더한 값
            if cost < distance[node[0]]:  # 그 노드를 거쳐가는게 더 이득이라면
                distance[node[0]] = cost  # 해당 노드까지의 거리를 그 값으로 갱신
                heapq.heappush(q, (cost, node[0]))
    return distance


def solution(n, s, a, b, fares): # 지점의 개수,출발지점,a도착지점,b도착지점,택시요금
    graph = [[] for _ in range(n+1)]
    for fare in fares:
        x, y, c = fare
        graph[x].append((y, c)) # 양방향 처리
        graph[y].append((x, c))

    distance = dijkstra(n, graph, s)  # s부터 시작해서 최소 이동 경로
    res = distance[a] + distance[b]  # 각각 따로 갔을 경우(합승x)

    # 얼마만큼 합승을 할 것인가?
    for i in range(1, n+1):
        if i == s: # 시작노드 s를 제외한 모든 지점에서 a와 b로 가는 최단거리 구함
            continue
        dist = dijkstra(n, graph, i)
        res = min(res, distance[i] + dist[a] + dist[b])
        # (합승안한 경우) vs (s에서 i로 이동 + i에서 a와 b로 이동) 중에 더 작은 값으로 갱신
    return res
