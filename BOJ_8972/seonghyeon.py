def pboard() :

    for r in board :

        print("".join(r))

def isCrazy(y,x) :

    return board[y][x] == 'R'

def move_jongsu(direction) :

    global loc_jongsu
    y,x = loc_jongsu

    ny = y + dy[direction]
    nx = x + dx[direction]

    if isCrazy(ny,nx) :

        return False

    else :

        loc_jongsu = (ny,nx)
        board[y][x] = '.'
        board[ny][nx] = 'I'
        return True


def move_crazy():
    global loc_ardu
    I_y, I_x = loc_jongsu
    new_loc_ardu = []
    loc_count = {}

    for y, x in loc_ardu:
        min_v = 1e9
        min_loc = (0, 0)

        for d in range(1, 10):
            ny = y + dy[d]
            nx = x + dx[d]
            if ny < 0 or nx < 0 or ny >= R or nx >= C:
                continue
            dist = abs(ny - I_y) + abs(nx - I_x)
            if min_v > dist:
                min_v = dist
                min_loc = (ny, nx)

        if min_loc == loc_jongsu:  # 종수의 아두이노와 만남
            return False

        new_loc_ardu.append(min_loc)

        # 위치에 대한 미친 아두이노 개수 파악
        if min_loc in loc_count.keys():
            loc_count[min_loc] += 1
        else:
            loc_count[min_loc] = 1

    tmp = []

    for y, x in loc_ardu:
        board[y][x] = "."

    for loc in new_loc_ardu:

        if loc in tmp or loc_count[loc] > 1:
            continue

        tmp.append(loc)

    loc_ardu = tmp

    for y, x in tmp:
        board[y][x] = "R"

    return True


R,C = map(int,input().split())
board = [list(map(str,input())) for _ in range(R)]
moves = list(map(int,input()))

dy = (-3, 1, 1, 1, 0, 0, 0, -1, -1, -1)
dx = (-3, -1, 0, 1, -1, 0, 1, -1, 0, 1)

loc_jongsu = (0,0)
loc_ardu = []

for y in range(R) :

    for x in range(C) :

        if board[y][x] == 'I' :

            loc_jongsu = (y,x)

        if board[y][x] == 'R' :

            loc_ardu.append((y,x))

for i, d in enumerate(moves):
    if not move_jongsu(d):
        print(f"kraj {i+1}")
        exit()
    if not move_crazy():
        print(f"kraj {i+1}")
        exit()
pboard()

