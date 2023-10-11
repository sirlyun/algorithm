'''
    스타트 택시
        손님을 도착지 떨궈주면 연료 재충전됨
        연료가 바닥나면 그날 업무 강제 종료
    M명의 승객 태우는게 목표
    NxN의 격자에서 각 칸은 비어있거나 벽이 놓여있음
    택시는 빈칸에서 상하좌우로 이동가능
    특정 위치 이동시 항상 최단 경로로 이동
    여러 승객이 같이 타는 거 불가능 -> M번 이동
    각 승객은 출발지에서만 탈 수 있고 목적지에만 내림
    승객 고를 때 기준
        1. 현재 택시 위치에서 가장 가까운 승객
        2. 행 번호가 가장 작은 승객
        3. 열 번호가 가장 작은 승객
    연로는 한칸당 1씩 소모
    한 승객을 성공적으로 이동시키면 그 승객 태우고 이동한 거리의 2배만큼 연료 재충전
    승객이 내린 동시에 연료가 바닥이면 성공으로 간주

'''

# 어떤 승객을 태울지 탐색
def find_client(chk, x, y):
    distance = [[1e9]*N for _ in range(N)]
    queue = []
    heapq.heappush(queue, (0, (x, y)))
    distance[x][y] = 0
    cnt = 0
    while queue:
        dist, now = heapq.heappop(queue)
        if now in chk:
            cnt += 1
        if cnt == len(clients):
            break
        if distance[now[0]][now[1]] < dist:
            continue
        for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            di = now[0]+dx
            dj = now[1]+dy
            if 0<=di<N and 0<=dj<N and arr[di][dj]!=1:
                if dist+1 < distance[di][dj]:
                    distance[di][dj] = dist+1
                    heapq.heappush(queue, (dist+1, (di, dj)))

    idx = 0
    next_client = [clients[0][0]-1, clients[0][1]-1]
    
    for n in range(1, len(clients)):
        # print(distance[next_client[0]-1][next_client[1]-1])
        if distance[clients[n][0]-1][clients[n][1]-1] < distance[next_client[0]][next_client[1]]:
            # print(False)
            next_client = [clients[n][0]-1, clients[n][1]-1]
            idx = n
        elif distance[clients[n][0]-1][clients[n][1]-1] == distance[next_client[0]][next_client[1]]:
            # print(True)
            if next_client[0] > clients[n][0]-1:
                next_client = [clients[n][0]-1, clients[n][1]-1]
                idx = n
            elif next_client[0] == clients[n][0]-1:
                if next_client[1] > clients[n][1]-1:
                    next_client = [clients[n][0]-1, clients[n][1]-1]
                    idx = n

    return idx, distance

def bfs(x, y, end):
    queue = [((x, y), 0)]
    while queue:
        now, cost = queue.pop(0)
        if now == end:
            return cost

        for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            di = now[0]+dx
            dj = now[1]+dy
            if 0<=di<N and 0<=dj<N and arr[di][dj]!=1:
                queue.append(((di, dj), cost+1))



import heapq
import sys
input = sys.stdin.readline
N, M, og_oil = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
# 택시 시작 점
# 행과 열 번호는 1 이상 N 이하의 자연수이고, 운전을 시작하는 칸은 빈칸이다.
start_x, start_y = map(int, input().split())
# 모든 출발지와 목적지는 빈칸이고, 모든 출발지는 서로 다르며, 각 손님의 출발지와 목적지는 다르다.
clients = [list(map(int, input().split())) for _ in range(M)]


while clients:
    # print(start_x, start_y)
    chk = []
    for client in clients:
        chk.append((client[0], client[1]))
    idx, distance = find_client(chk, start_x-1, start_y-1)
    # 누구 태울지 골랐음
    now_client = clients.pop(idx)
    # print(now_client)
    # 승객 태우러 가면서 연료 쓰기
    og_oil -= distance[now_client[0]-1][now_client[1]-1]
    # print(distance[now_client[0]-1][now_client[1]-1])
    # print(start_x, start_y)
    # print(now_client)
    # print(og_oil)
    if og_oil < 0:
        print(-1)
        break
    # 승객 태우고 목적지까지 가자
    cost = bfs(now_client[0]-1, now_client[1]-1, (now_client[2]-1, now_client[3]-1))
    # print(cost)
    og_oil -= cost
    # print(og_oil)
    if og_oil < 0:
        print(-1)
        break
    og_oil += cost*2

    start_x, start_y = now_client[2], now_client[3]
    
else:
    print(og_oil)