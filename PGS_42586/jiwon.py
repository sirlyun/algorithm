def solution(progresses, speeds):
    answer = []
    index = 0
    while True:
        for i in range(len(progresses)):
            progresses[i] += speeds[i]
        cnt = 0
        for i in range(index, len(progresses)):
            if progresses[i] >= 100:
                cnt += 1
            else:
                break
        if cnt > 0: # 배포할 것이 있는가?
            answer.append(cnt)
            index += cnt
        if sum(answer) == len(progresses): # 전부 배포했는가?
            return answer