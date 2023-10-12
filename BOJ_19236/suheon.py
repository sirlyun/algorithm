import copy

def shark_game(i,j,d,s,catch):
    global max_v
    if catch == 16:
        if max_v < s:
            max_v = s
        return
    else:
        candidate = []
        p = 1
        while True:
            ni = i + (dir[d][0] * p)
            nj = j + (dir[d][0] * p)
            if 0<=ni<4 and 0<=nj<4:
                candidate.append([ni,nj])
            else:
                break

        if not candidate: # 먹을 게 없음
            return

        # 먹을 거 선택
        for x,y in candidate:
            ee = copy.deepcopy(eaten)
            v = [[0]* 4 for _ in range(4)]

            ee[arr[x][y][0]] = 1  # 먹히면 1임
            arr[x][y] = [0, 0]  # 먹히면 0,0
            v[x][y] = 1


def fish_move(x):
    for i in range(4):
        for j in range(4):
            if arr[i][j][0] == x: # 그 물고기이면
                # 방향으로 갈 곳
                d = arr[i][j][1]
                cnt = 0
                while cnt != 8:
                    ni = i + dir[d][0]
                    nj = j + dir[d][1]
                    if 0 <= ni < 4 and 0 <= nj < 4:
                        if v[ni][nj] == 0:
                            break
                    cnt += 1
                    d = (d+1) % 8

                # 나왔으면 방향이랑 ni,nj가 정해짐
                # 방향 갱신
                if cnt < 8:
                    arr[i][j][1] = d
                    arr[i][j], arr[ni][nj] = arr[ni][nj], arr[i][j]
                    # 다시 돌지 않도록 해야 함
                    return

arr = [[[] for _ in range(4)] for _ in range(4)]

for i in range(4):
    x = list(map(int, input().split()))
    for j in range(8):
        m = j // 2
        r = j % 2
        if r == 0: # 짝수면 물고기 번호
            arr[i][m].append(x[j])
        else:
            arr[i][m].append(x[j]-1)
# 번호, 방향
dir = [[-1,0],[-1,-1],[0,-1],[1,-1],[1,0],[1,1],[0,1],[-1,1]]

# 먹힌 친구 숫자
eaten = [0] * 17
# 상어 위치 표시
v = [[0] * 4 for _ in range(4)]
# 초기 상어

# shark = [arr[0][0][0],arr[0][0][1]]
eaten[arr[0][0][0]] = 1 # 먹히면 1임
arr[0][0] = [0,0] # 먹히면 0,0
v[0][0] = 1

max_v = arr[0][0][0]

# 초기 물고기 이동
for i in range(1, 17):  # 1부터 16까지
    # 안먹힌거
    if eaten[i] == 0:
        fish_move(i)

v[0][0] = 1

print(arr)

# 시작
shark_game(0,0,arr[0][0][1],arr[0][0][0],1,arr,eaten,) # 상어 위치, 방향, 합, 먹은 애들