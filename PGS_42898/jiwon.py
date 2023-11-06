
def solution(m, n, puddles):
    dp = [[0] * (m+1) for _ in range(n+1)]
    dp[1][1] = 1
    for i, j in puddles: # 웅덩이는 -1
        dp[j][i] = -1

    for i in range(1, n+1):
        for j in range(1, m+1):
            if i == 1 and j == 1: # 시작위치 제외
                continue

            if dp[i][j] == -1: # 웅덩이라면?
                dp[i][j] = 0
            else:
                dp[i][j] = dp[i][j-1] + dp[i-1][j] # 왼쪽, 위 dp값 모두 더함(오른쪽, 아래로만 갈 수 있으므로)

    return dp[n][m] % 1000000007
