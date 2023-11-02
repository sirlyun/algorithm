'''
항상 높이가 더 낮은 지점으로만 이동
'''

def dfs(i,j):
    di = [0, 1, 0, -1]
    dj = [1, 0, -1, 0]
    # 도착점이면 1을 리턴해서 돌아가게 함
    if i == M-1 and j == N-1:
        return 1

    # -1이 아닌 곳을 찾으면
    if dp[i][j] != -1:
        return dp[i][j]

    # 일단 0채우기
    dp[i][j] = 0

    # 재귀
    for k in range(4):
        ni = i+di[k]
        nj = j+dj[k]

        # 범위
        if ni < 0 or ni >= M or nj <0 or nj >= N:
            continue
        # 낮은 지점으로만 이동
        if arr[ni][nj] >= arr[i][j]:
            continue

        dp[i][j] += dfs(ni,nj)

    # 갈 데 없으믄?
    return dp[i][j]



M, N = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(M)]
dp = [[-1] * N for _ in range(M)]

dfs(0,0)

print(dp[0][0])