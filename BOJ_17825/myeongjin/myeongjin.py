'''
1. dfs 재귀를 이용해 분기를 만드는데.. 조건이 있다..
<조건>
(1) 기저 조건 : 10이 되면 끝내고(start) 칸을 다 세면서 누적하는 변수(sum_num)로 누적한다
-> 인자 2개
(2) dfs 조건 분기 : 말의 위치를 나타내서 말이 있는 곳에 가지 못하게 하는 배열 horses
-> 인자 1개
'''

def array(): # 그래프 만들기!!
    out = [2*i for i in range(21)] + [13, 16, 19, 22, 24, 28, 27, 26, 25, 30, 35, 0]

    new_arr = [[] for _ in range(33)]
    # 첫 번째 분기
    new_arr[5].append(21)
    new_arr[21].append(22)
    new_arr[22].append(23)
    new_arr[23].append(29)
    # 두 번째 분기
    new_arr[10].append(24)
    new_arr[24].append(25)
    new_arr[25].append(29)
    # 세 번째 분기
    new_arr[15].append(26)
    new_arr[26].append(27)
    new_arr[27].append(28)
    new_arr[28].append(29)
    # 합쳐지는 분기
    new_arr[29].append(30)
    new_arr[30].append(31)
    new_arr[31].append(20)
    new_arr[20].append(32)
    for j in range(20):
        new_arr[j].append(j+1)

    return out, new_arr # 값과 인접 리스트 반환


def dfs(horses, sum_num, start):
    global max_num

    if start == 10: # 10번 채우면 max 값 반환
        max_num = max(sum_num, max_num)
        return

    for i in range(4): # 말을 보면서
        horse = horses[i] # 말 하나 골라서 말 시작 위치 저장
        end, score = move(horse, dice[start])

        # 도착 지점에 있거나, 중간점이고 도착 위치에 말이 없으면
        if end == 32 or (end < 32 and end not in horses):
            before = horses[i] # 말 이전 위치 저장
            horses[i] = end # 말 이동
            dfs(horses, sum_num + score, start+1)
            horses[i] = before # 초기화


def move(st, num): # 시작점과 주사위 횟수
    stack = [st]

    while num > 0:

        t = stack.pop()
        if len(idx[t]) == 0: # 도착 지점에 도착하면
            return 32, 0 # 도착점과 점수 반환

        for i in idx[t]:
            if st == 5 or st == 10 or st == 15: # 분기 시작이면
                stack.append(idx[t][0])
            elif st != 5 and st != 10 and st != 15 or num > 0: # 분기가 아니고 횟수가 남았으면
                if len(idx[t]) == 2: # 도중에 분기를 만나면 그래도 직진
                    stack.append(idx[t][1])
                else: # 분기가 없으면 다음
                    stack.append(i)
            break

        num -= 1
        if num == 0:
            X = stack.pop() # 도착점
            V = value[X] # 점수
            return X, V # 도착점과 점수 반환


dice = list(map(int, input().split()))
value, idx = array()
max_num = 0
dfs([0, 0, 0, 0], 0, 0)
print(max_num)
