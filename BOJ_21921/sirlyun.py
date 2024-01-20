'''
    블로그 시작한지 N일이 지남
    X일 동안 가장 많이 들어온 방문자 수와 기간이 몇개 있는가
'''

N, X = map(int, input().split())
visitors = list(map(int, input().split()))
sum_visitors = sum(visitors[:X])
front = visitors[0]
front_idx = 0
max_visitors = sum_visitors
result = 1

for i in range(X, N):
    sum_visitors -= front
    sum_visitors += visitors[i]
    if max_visitors < sum_visitors:
        max_visitors = sum_visitors
        result = 1
    elif max_visitors == sum_visitors:
        result += 1
    front_idx += 1
    front = visitors[front_idx]

if max_visitors == 0:
    print('SAD')
else:
    print(max_visitors)
    print(result)