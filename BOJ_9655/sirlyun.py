'''
    돌 N개
    번갈아가면서 돌을 가져간다 (1개 또는 3개)
    마지막 돌을 가져가는 사람이 승리
'''

N = int(input())

dp = ['']*1001
dp[1] = 'SK'
dp[2] = 'CY'
dp[3] = 'SK'

for i in range(4, N+1):
    if dp[i-1] == 'SK' or dp[i-3] == 'SK':
        dp[i] = 'CY'
    else:
        dp[i] = 'SK'

print(dp[N])