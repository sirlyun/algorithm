def solution(N, stages):

    answer = []
    total = len(stages)
    fail = []

    for i in range(1,N+1) :

        if total == 0 :

            fail.append((0,i))
            continue

        players = stages.count(i)
        fail_rate = players / total
        fail.append((fail_rate, i))
        total -= players

    fail.sort(key=lambda x: (-x[0], x[1]))
    answer = [stage for i, stage in fail]

    return answer

N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
print(solution(N, stages))
