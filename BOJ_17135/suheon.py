import copy
def gamestart(c,arr):
    # for i in c:
    #     arr[N+1][i] = 'B'
    # 0~N-1까지 1이 없을 때
    kill_count = 0
    while True:
        cnt = 0
        # 적들의 좌표
        enemy = []
        for i in range(N):
            for j in range(M):
                if arr[i][j] == 1:
                    cnt += 1
                    enemy.append([i,j]) # 가장 왼쪽에 있는 놈부터 잡아야 함
        if cnt == 0:
            break

        # 적 제거
        shot_him = []
        for k in c:
            ## 거리 가장 작은 적들 좌표 -> 많으면 제외시켜야 함
            can_shoot = []
            min_d = 200
            bi, bj = N, k
            for i,j in enemy:
                distance = abs(bi-i) + abs(bj-j)
                if distance <= D:
                    # 작을 때는 갱신
                    if min_d > distance:
                        can_shoot = []
                        min_d = distance
                        ## 같은 적들 중에서는 j가 가장 작은 거
                        can_shoot.append([j,i])
                    if min_d == distance:
                        can_shoot.append([j, i])
            if can_shoot:
                can_shoot.sort() # j기준 오름차순
                if [can_shoot[0][1],can_shoot[0][0]] not in shot_him:
                    shot_him.append([can_shoot[0][1],can_shoot[0][0]]) # 다시 i,j로

        if shot_him:
            for i,j in shot_him:
                arr[i][j] = 0
                kill_count += 1


        # 적 이동
        arr.pop()
        arr.insert(0, [0]*M)

    return kill_count



def comb(n,r):
    global max_v
    if r == 0:
        gamepan = copy.deepcopy(arr)
        pt = gamestart(c,gamepan)
        if max_v < pt:
            max_v = pt
        return
    elif n < r:
        return
    else:
        c[r-1] = candidate[n-1]
        comb(n-1,r-1)
        comb(n-1,r)

N, M, D = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

arr.append([0] * M)

# 3개의 행을 뽑아야 함
candidate = [i for i in range(M)]
c = [0] * 3

max_v = 0

comb(M,3)

print(max_v)