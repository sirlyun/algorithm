import heapq as hq


def dijk(start, end):
    heap = []
    for i in arr[start]:
        hq.heappush(heap, (-i[0], i[1]))  # 최대 힙

    while heap:
        w, f = hq.heappop(heap)  # 중량, 시작점
        w = -w

        if f == end:  # 시작점 == 끝점일 때,
            print(w)
            break

        if weight[f] > w:  # 중량이 작으면 skip
            continue

        for nw, t in arr[f]:  # 다음 지점까지의 중량과 다음 노드

            if weight[t] < nw and weight[t] < w:  # 기존의 중량을 시작점에서 다음점 중량, 갖고 있는 중량과 비교
                weight[t] = min(nw, w)  # 시작점에서 다음점 중량과 갖고 있는 중량의 최솟값을 할당
                hq.heappush(heap, (-weight[t], t))


N, M = map(int, input().split())  # 노드 수, 간선 수
arr = [[] for _ in range(N + 1)]
for i in range(M):  # 인접 리스트
    f, t, w = map(int, input().split())
    arr[f].append((w, t))
    arr[t].append((w, f))
start, end = map(int, input().split())  # 시작점, 끝점

for i in range(1, N + 1):  # 최대 중량을 우선으로 내림차순 정렬
    arr[i].sort(reverse=True)

weight = [0] * (N + 1)  # 시작점부터 다음 노드까지의 중량

dijk(start, end)
