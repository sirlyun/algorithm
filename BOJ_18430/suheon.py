'''
만들 수 있는 부메랑 강도 최대 합
중앙은 강도 2배
(1 ≤ N, M ≤ 5) => 완전탐색

지원햄 코드 참고
=> for문 재귀 최소화
'''

def f(i,j,s): # 중앙좌표
    global max_v
    if j == M: # 다음 행으로
        i += 1
        j = 0
    if i == N: # 모든 좌표 돌아봤을 때 리턴
        if max_v < s:
            max_v = s
        return
    if v[i][j] == 0:
        for k in range(4):
            strength = 0
            di1 = boo[k][0]
            dj1 = boo[k][1]

            di2 = boo[k][2]
            dj2 = boo[k][3]

            ni1 = i+di1
            nj1 = j+dj1

            ni2 = i+di2
            nj2 = j+dj2
            if (ni1 < 0 or ni1 >= N or nj1 < 0 or nj1 >= M
                    or ni2 < 0 or ni2 >= N or nj2 < 0 or nj2 >= M
                    or v[ni1][nj1] == 1 or v[ni2][nj2] == 1): # 범위 벗어나면 안됨
                continue
            # 부메랑 완전히 만들 수 없으면 안만들고 넘어가기
            # 부메랑 강도 합
            strength += ((arr[i][j] * 2) + arr[ni1][nj1] + arr[ni2][nj2])
            # 방문기록
            v[i][j] = 1
            v[ni1][nj1] = 1
            v[ni2][nj2] = 1
            f(i,j+1,s+strength)
            # 재귀 다녀옴
            v[i][j] = 0
            v[ni1][nj1] = 0
            v[ni2][nj2] = 0
    f(i, j + 1, s)

N,M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

max_v = 0

boo = [
    [0,-1,1,0], # 1
    [0,-1,-1,0], # 2
    [0,1,-1,0], # 3
    [0,1,1,0] # 4
]

# 방문 기록
v = [[0] * M for _ in range(N)]

if N < 2 or M < 2:
    print(0)
else:
    f(0,0,0)
    print(max_v)