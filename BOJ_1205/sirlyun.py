N, new_score, P = map(int, input().split())
if N == 0:
    print(1)
else:
    ranking = list(map(int, input().split()))
    if N == P and ranking[-1] >= new_score:
        print(-1)
    else:
        result = N+1
        for i in range(N):
            if ranking[i] <= new_score:
                result = i+1
                break
        print(result)