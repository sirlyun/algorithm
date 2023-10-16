'''
    게임은 RxC 크기의 보드에서 이루어진다.
    미친 아두이노를 피해다녀야 한다
        종수가 아두이노를 8가지 방향(수직,수평,대각선)으로 이동시키거나, 그 위치에 그대로 놔둔다.
        종수의 아두이노가 미친 아두이노가 있는 칸으로 이동한 경우에는 게임이 끝나게 되며, 종수는 게임을 지게 된다.
        미친 아두이노는 8가지 방향 중에서 종수의 아두이노와 가장 가까워 지는 방향으로 한 칸 이동한다. 
            즉, 종수의 위치를 (r1,s1), 미친 아두이노의 위치를 (r2, s2)라고 했을 때, |r1-r2| + |s1-s2|가 가장 작아지는 방향으로 이동한다. 
        미친 아두이노가 종수의 아두이노가 있는 칸으로 이동한 경우에는 게임이 끝나게 되고, 종수는 게임을 지게 된다.
        2개 또는 그 이상의 미친 아두이노가 같은 칸에 있는 경우에는 큰 폭발이 일어나고, 그 칸에 있는 아두이노는 모두 파괴된다.
        입력으로 주어진 방향대로 종수가 움직였을 때, 보드의 상태를 구하는 프로그램을 작성하시오. 중간에 게임에서 지게된 경우에는 몇 번째 움직임에서 죽는지를 구한다.
'''


R, C = map(int, input().split())
board = []
a_x, a_y = 0, 0
crazy_list = set()

for r in range(R):
    arr = input()
    chk = []
    for c in range(C):
        if arr[c] == 'I':
            a_x, a_y = r, c
        elif arr[c] == 'R':
            crazy_list.add((r, c))
        chk.append(arr[c])

    board.append(chk)

d_str = input()

dx = [1, 1, 1, 0, 0, 0, -1, -1, -1]
dy = [-1, 0, 1, -1, 0, 1, -1, 0, 1]

cnt = 0
for d in d_str:
    cnt += 1
    
    # 방향 설정
    now_dx = dx[int(d)-1]
    now_dy = dy[int(d)-1]
    # 종.아 이동하기
    a_x += now_dx
    a_y += now_dy


    if (a_x, a_y) in crazy_list:
        print(f'kraj {cnt}')
        break
    
    check = set()
    crash = set()
    for crazy in crazy_list:
        chk = 1e9
        chose_x, chose_y = 0, 0

        for i in range(9):
            if i == 4:
                continue
            di = crazy[0]+dx[i]
            dj = crazy[1]+dy[i]

            if 0<=di<R and 0<=dj<C:
                dist = abs(a_x-di) + abs(a_y-dj)
                if chk > dist:
                    chk = dist
                    chose_x, chose_y = di, dj
            

        if a_x == chose_x and a_y == chose_y:
            print(f'kraj {cnt}')
            break
        elif (chose_x, chose_y) in check:
            crash.add((chose_x, chose_y))
        else:
            check.add((chose_x, chose_y))

        if (chose_x, chose_y) in crash:
            check.remove((chose_x, chose_y))
        
    else:
        crazy_list = check
        continue
    break


else:
    new_board = [['.' for _ in range(C)] for _ in range(R)]
    for r in range(R):
        for c in range(C):
            if (r, c) in crazy_list:
                new_board[r][c] = 'R'
    new_board[a_x][a_y] = 'I'

    for b in new_board:
        for i in b:
            print(i, end='')
        print()