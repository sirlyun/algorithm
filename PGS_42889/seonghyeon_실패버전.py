def findresult(i) :

    global stages

    length = len(stages)
    visited = [0 for _ in range(length)]
    idx = 0
    cnt = 0

    for j in stages :

        if i == j :

            cnt += 1
            visited[idx] = 1

        idx += 1

    for k in range(len(visited)) :

        if visited[k] == 1:

            stages[k] = 0

    while 0 in stages :

        stages.remove(0)

    return cnt / length

def solution(N, stages):

    answer = []
    before_answer = []

    for i in range(1, N + 1):

        result = findresult(i)
        before_answer.append((result,i))

    before_answer.sort(reverse=True)
    before_answer = sorted(before_answer,key=lambda x : (-x[0],x[1]))

    for i in before_answer :

        answer.append(i[1])

    return answer

N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]

print(solution(N,stages))
