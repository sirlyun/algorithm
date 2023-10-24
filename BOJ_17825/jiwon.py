def roll(cnt, score):
    global res
    if cnt == 10:  # 주사위를 모두 굴렸을 경우
        res = max(res,score)
        return

    for i in range(4):

        route, idx = horse[i] # 현재 루트, 위치
        next_route, next_idx = route, idx + dice[cnt] # 다음 루트, 위치

        if route == -1:  # 이미 도착 지점
            continue
        if route == 4 and len(r[route]) <= next_idx: # 25를밟음, 도착지점
            next_route, next_idx = -1, -1
        elif route == 0 and len(r[route])+1 <= next_idx: # 원래루트, 도착지점
            next_route, next_idx = -1, -1
        elif route in [1,2,3] and idx == len(r[route])-1 and dice[cnt] == 5: # 10,20,30중 하나를 밟고, 주사위5로 도착
            next_route, next_idx = -1, -1
        else:
            if route == 0 and (next_idx in [5,10,15,20]): # 원래루트고, 다음위치가 네 루트시작점일때
                if next_idx == 5:
                    next_route = 1
                    next_idx = 0   # 루트를 바꿨으니 새로시작이라 인덱스 초기화
                elif next_idx == 10:
                    next_route = 2
                    next_idx = 0
                elif next_idx == 15:
                    next_route = 3
                    next_idx = 0
                else:
                    next_route = 4
                    next_idx = 3
            elif route in [1,2,3] and len(r[route]) <= next_idx: # 123루트고 25밟음
                next_route, next_idx = 4, next_idx - len(r[route])
            if [next_route,next_idx] in horse: # 다음위치가 겹치지 않았으면 킾고잉
                continue
        horse[i] = [next_route,next_idx]  # 다음위치
        if next_route == -1:
           roll(cnt+1,score)
        else:   # 도착안했으면 다른 경로로 이동하는지 파악
            roll(cnt+1, score+r[next_route][next_idx])
        horse[i] = [route,idx] # 백

horse = [[0, 0]] * 4  # 말의 위치와 루트 기록
dice = list(map(int, input().split()))  # 주사위 10개
# 루트 5개
r1 = [x for x in range(0, 40, 2)]
r2 = [10, 13, 16, 19]  # 10도착
r3 = [20, 22, 24]  # 20도착
r4 = [30, 28, 27, 26]  # 30도착
r5 = [25, 30, 35, 40]  # 25도착
r = [r1, r2, r3, r4, r5]
res = 0
roll(0, 0)
print(res)