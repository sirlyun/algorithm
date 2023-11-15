from collections import deque
N,d,k,c = map(int, input().split())

eat = deque()

sushi = [0] * N
for i in range(N):
    x = int(input())
    if i < k:
        eat.append(x)
    sushi[i] = x

# 초기화
eat.append(c)
max_v = len(list(set(eat)))
eat.pop()

for i in range(1,N):
    i2 = i+k-1
    if i2 > N-1:
        i2 = i2 % N
    eat.popleft()
    eat.append(sushi[i2])
    eat.append(c)
    temp = len(list(set(eat)))
    if temp > max_v:
        max_v = temp
    eat.pop()

print(max_v)
