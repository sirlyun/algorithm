'''
트리 구조
한 번에 한 사람씩 직속 부하에게 전화
모든 직원이 소식을 듣는데 걸리는 시간의 최솟값
부하 직원이 많은 쪽을 우선적으로 선택해야 한다.
우선순위 큐 => BFS?
'''
import heapq
def bfs(s):
    pq = []
    # 파이썬 최소 힙 -> 음수로 바꿔줘야 함, 처음은 상관 없음
    heapq.heappush(pq, (child[s], s, 0)) # 자식 노드 수, 그 곳, 이전 연락 시간

    visited = [0] * N
    visited[0] = 0

    while pq:
        num_child, i, time = heapq.heappop(pq)

        # 자식 수 많은 거 부터 시간늘리고 큐에 넣기
        temp = []
        for j in arr[i]:
            temp.append([child[j],j])
        temp.sort(reverse=True)  # 큰 거부터 정렬
        for j in range(len(temp)):
            heapq.heappush(pq, (-child[temp[j][1]],temp[j][1], time+j+1))
            visited[temp[j][1]] = time+j+1

    return max(visited)

def dfs(s): # 자식 수 찾기
    cnt = 0 # 그 노드 자식 수
    # 끝에 오면 1개 return 시켜줌
    if not arr[s]:
        return 1

    # 갈 수 있는 곳 돌기
    for w in arr[s]:
        cnt += dfs(w) # 리턴된 거 값 더해주기

    # 그 노드의 자식 수 저장
    child[s] = cnt
    # 자기 자신 포함해서 위 쪽으로 리턴 시켜줌
    return cnt+1



N = int(input())
x = list(map(int ,input().split()))

arr = [[] for _ in range(N)]
child = [0] * N

# 인접 리스트
for i in range(N):
    if i == 0:
        continue
    arr[x[i]].append(i)

# 자식 수 세기
dfs(0)
# 최소값 찾기
print(bfs(0))