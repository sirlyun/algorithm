'''
    두 나라가 얻은 메달 수가 주어진다.
    누가 더 잘했는가
        1. 금메달 수가 더 많은 나라
        2. 은메달 수가 더 많은 나라
        3. 동메달 수가 더 많은 나라
    각 국가는 1부터 N까지 수로 표현됨
    한 국가의 등 수는 (자신보다 더 잘한 나라 수)+1
'''

# N : 국가 수, K : 몇 등인지 알고싶은 나라
N, K = map(int, input().split())

countrys = [[] for _ in range(N+1)]
for n in range(N):
    a, b, c, d = map(int, input().split())
    countrys[a].append(b)
    countrys[a].append(c)
    countrys[a].append(d)

count = 0

for n in range(1, N+1):
    # 본인 나라 제외
    if n == K:
        continue
    else:
        if countrys[n][0] < countrys[K][0]:
            continue
        else:
            if countrys[n][0] > countrys[K][0]:
                count += 1
            else:
                if countrys[n][1] < countrys[K][1]:
                    continue
                else:
                    if countrys[n][1] > countrys[K][1]:
                        count += 1
                    else:
                        if countrys[n][2] < countrys[K][2]:
                            continue
                        else:
                            if countrys[n][2] > countrys[K][2]:
                                count += 1

print(count+1)