'''
만들 수 있는 부메랑 강도 최대 합
중앙은 강도 2배
(1 ≤ N, M ≤ 5) => 완전탐색
'''

def f(i,j,s): # 중앙좌표
    global max_v
    if i == N: # 모든 좌표 돌아봤을 때 리턴
        if max_v < s:
            max_v = s
        return
    elif j == M: # 다음 행으로
        f(i+1,0,s)
    elif v[i][j] == 1:
        f(i,j+1,s)
    else:
        for k in range(4):
            # temp 초기화
            temp = []
            strength = 0
            for di,dj in boo[k]:
                # 좌표 저장할 배열
                ni = i+di
                nj = j+dj
                if ni < 0 or ni >= N or nj < 0 or nj >= M: # 범위 벗어나면 안됨
                    continue
                if v[ni][nj] == 1:
                    continue
                temp.append([ni,nj])
            # 부메랑 완전히 만들 수 없으면
            if len(temp) != 2:
                f(i, j+1, s) ## 안만들고 넘어가기
                continue
            # 부메랑 강도 합
            strength += ((arr[i][j] * 2) + arr[temp[0][0]][temp[0][1]] + arr[temp[1][0]][temp[1][1]])
            # 방문기록
            v[i][j] = 1
            v[temp[0][0]][temp[0][1]] = 1
            v[temp[1][0]][temp[1][1]] = 1
            f(i,j+1,s+strength)
            # 재귀 다녀옴
            v[i][j] = 0
            v[temp[0][0]][temp[0][1]] = 0
            v[temp[1][0]][temp[1][1]] = 0



N,M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

max_v = 0

boo = [
    [[0,-1],[1,0]], # 1
    [[0,-1],[-1,0]], # 2
    [[0,1],[-1,0]], # 3
    [[0,1],[1,0]] # 4
]

# 방문 기록
v = [[0] * M for _ in range(N)]

if N < 2 or M < 2:
    print(0)
else:
    f(0,0,0)
    print(max_v)