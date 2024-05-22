'''
    정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수는?
'''

T = int(input())
dp = [[0]*4 for _ in range(10001)]
dp[1][1] = 1
dp[2][1] = 1
dp[2][2] = 1
dp[3][1] = 1
dp[3][2] = 1
dp[3][3] = 1
for t in range(T):
    N = int(input())

    for n in range(4, N+1):
        dp[n][1] = dp[n-1][1]
        dp[n][2] = dp[n-2][1] + dp[n-2][2]
        dp[n][3] = dp[n-3][1] + dp[n-3][2] + dp[n-3][3]

    print(sum(dp[N]))