'''
    자신의 위치에서 거리가 K이하인 햄버거를 먹을 수 있다.
'''

N, K = map(int, input().split())
table = list(input())
result = 0
for n in range(N):
    if table[n] == 'P':
        for i in range(max(n-K, 0), min(n+K+1, N)):
            if table[i] == 'H':
                table[i] = 0
                result += 1
                break
print(result)