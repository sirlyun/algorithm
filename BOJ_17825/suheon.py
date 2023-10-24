'''
오래 걸린 이유 => 재귀 다녀왔을 때 이전 상태로 되돌려 줘야 함 + 리스트 만들 때 잘 못 만듬

윤설 코드 좀 참고하고 품


활용 알고리즘 : 완전탐색

'''

def f(i,score):
    # 주사위 다 던짐
    global ans
    if i == 10:
        if ans < score:
            ans = score
        return

    else:
        for j in range(4):
            x = mal[j]
            # 도착지점이라면 continue
            if x == 32:
                continue
            # 말 이동하기
            cnt = 0
            # 그 지점이 5,10,15이면
            if x == 5 or x == 10 or x == 15:
                x = mmap[x][1]
                cnt += 1
            while True:
                # 주사위 눈 수 = dice[i]
                if cnt == dice[i]:
                    break
                # 도착했으면 break
                if x == 32:
                    break
                x = mmap[x][0]
                cnt += 1

            # 가려는 지점에 말이 있는지 판별
            if x != 32:
                if x in mal:
                    continue

            # 갱신
            ## 재귀 다녀와서 이전으로 돌려줘야함
            before = mal[j]
            mal[j] = x
            f(i+1,score+pt[mal[j]])
            mal[j] = before


dice = list(map(int, input().split()))
# 점수
pt = [0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,13,16,19,25,30,35,22,24,28,27,26,0]

# 인접리스트
mmap = [
    [1],
    [2],
    [3],
    [4],
    [5],
    [6,21],
    [7],
    [8],
    [9],
    [10],
    [11,27],
    [12],
    [13],
    [14],
    [15],
    [16,29],
    [17],
    [18],
    [19],
    [20],
    [32],
    [22],
    [23],
    [24],
    [25],
    [26],
    [20],
    [28],
    [24],
    [30],
    [31],
    [24],
]

ans = 0
mal = [0] * 4

f(0,0)

print(ans)