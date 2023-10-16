R, C = map(int, input().split())
arr = [list(input()) for _ in range(R)]

j_dir = list(map(int, input()))

dir = [[1,-1],[1,0],[1,1],[0,-1],[0,0],[0,1],[-1,-1],[-1,0],[-1,1]]

c_duino = []
jsi = 0
jsj = 0

for i in range(R):
    for j in range(C):
        if arr[i][j] == 'R':
            c_duino.append([i,j])
        if arr[i][j] == 'I':
            jsi = i
            jsj = j

j_move = 0
lose = 0

while True:
    if j_move == len(j_dir):
        break

    # 1. 종수 이동
    arr[jsi][jsj] = '.'

    jsi = jsi+dir[j_dir[j_move]-1][0]
    jsj = jsj+dir[j_dir[j_move]-1][1]

    j_move += 1

    # 2. 종수 미친아두이노 만나면 게임 짐
    if arr[jsi][jsj] == 'R':
        lose = 1
    if lose == 1:
        break

    arr[jsi][jsj] = 'I'

    leng = len(c_duino)
    pung = []

    a = set() # 이동 예정
    b = set() # 충돌 위치
    # 3. 미친 아두이노 이동 (가까워지는 방향)
    for i in range(leng):
        arr[c_duino[i][0]][c_duino[i][1]] = '.'
        min_v = int(1e9)
        min_v_dir = 0
        t = 0
        for d in range(9):
            if d == 4:
                continue
            nx = c_duino[i][0] + dir[d][0]
            ny = c_duino[i][1] + dir[d][1]
            if 0<=nx<R and 0<=ny<C:
                t = abs(nx-jsi) + abs(ny-jsj)
                if min_v > t:
                    min_v = t
                    min_v_dir = d

        c_duino[i][0] = c_duino[i][0] + dir[min_v_dir][0]
        c_duino[i][1] = c_duino[i][1] + dir[min_v_dir][1]

        # 4. 만나면 게임 짐
        if arr[c_duino[i][0]][c_duino[i][1]] == 'I':
            lose = 1
            break
        # a에 있으면 -> 이동예정인 것을 충돌위치로 옮김
        if tuple(c_duino[i]) in a:
            a.remove(tuple(c_duino[i]))
            b.add(tuple(c_duino[i]))
        # b에 있으면 -> 의미 없는 거 같음
        elif tuple(c_duino[i]) in b:
            continue
        # 아무데도 없으면
        else:
            a.add(tuple(c_duino[i]))

    if lose == 1:
        break
    # 5. 2개 이상 미친 아두이노 같은 칸 -> 폭발 -> 그 칸의 아두이노 모두 파괴

    a = list(a)
    for i in range(len(a)):
        a[i] = list(a[i])
        arr[a[i][0]][a[i][1]] = 'R'

    c_duino = a


if lose == 1: # 중간에 끊김
    print(f'kraj {j_move}')
else:
    for i in range(R):
        print(*arr[i], sep='')
