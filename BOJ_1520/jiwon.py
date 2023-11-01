def dfs(i, j):
    if i == m - 1 and j == n - 1:  # 도착 지점에 도달
        return 1  # 경우의 수 1

    if dp[i][j] == -1:  # 탐색하지 않은 곳이면?
        dp[i][j] = 0  # 탐색

        for ti, tj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            ni, nj = i + ti, j + tj
            if 0 <= ni < m and 0 <= nj < n and arr[i][j] > arr[ni][nj]:
                dp[i][j] += dfs(ni, nj)  # (i,j)부터 도착지점까지 갈 수 있는 경우의 수 업뎃

    # 탐색한 곳이라면? 그 위치에서 출발하는 경우의 수 리턴
    return dp[i][j]


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(m)]
dp = [[-1] * n for _ in range(m)]
print(dfs(0, 0))