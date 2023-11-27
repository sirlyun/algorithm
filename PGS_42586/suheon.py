import math
def solution(progresses, speeds):
    answer = []
    leng = len(progresses)

    # 며칠이 걸리는지
    new = [0] * leng
    for i in range(leng):
        new[i] = math.ceil(((100 - progresses[i]) / speeds[i]))

    temp = new[0]
    cnt = 1
    idx = 1
    while True:
        if idx == leng:
            break
        # 더 큰게 나왔을 때 갱신
        if temp < new[idx]:
            temp = new[idx]
            answer.append(cnt)
            cnt = 0
            continue
        else:
            cnt += 1
            idx += 1
    # 마지막 남아있는 거
    answer.append(cnt)

    return answer