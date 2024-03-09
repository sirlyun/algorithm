'''
    매칭 기준
        매칭 가능한 방이 없다면 새로운 방을 생성하고 입장
        방에는 처음 입장한 사람 기준으로 -10~+10 까지 입장 가능
        입장 가능한 방이 있다면 입장 시킨 후 방의 정원이 모두 찰 때까지 대기
            가능한 방이 여러 개라면 먼저 생성된 방에 입장
        방의 정원이 모두 차면 게임 시작 시킴
'''

# P: 플레이어 정원 M: 방의 정원
P, M = map(int, input().split())
rooms = []

for _ in range(P):
    level, name = input().split()
    level = int(level)

    if rooms:
        flag = False
        for room in rooms:
            if (room[0][0]-10 <= level <= room[0][0]+10) and len(room) != M:
                room.append([level, name])
                flag = True
                break
        if not flag:
            rooms.append([[level, name]])
    else:
        rooms.append([[level, name]])

for room in rooms:
    room.sort(key=lambda x : x[1])

for room in rooms:
    if len(room) == M:
        print('Started!')
        for r in room:
            print(f'{r[0]} {r[1]}')
    else:
        print('Waiting!')
        for r in room:
            print(f'{r[0]} {r[1]}')