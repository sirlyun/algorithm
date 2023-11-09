import math


def solution(fees, records):
    answer = []
    temp = []

    for record in records:
        # 바꾸기
        time, num, io = record.split(' ')
        h, m = map(int, time.split(':'))
        time = h * 60 + m
        # num = int(num)

        # num 기준으로 정렬
        temp.append([num, time])
    temp.sort()

    current = temp[0][0]
    nunu = 0
    cnt = 0

    for i in range(len(temp)):
        if i > 0 and temp[i][0] != temp[i - 1][0]:
            cnt = 0
            answer.append(nunu)
            nunu = 0
            current = temp[i][0]
        if cnt % 2 == 0:
            nunu -= temp[i][1]
            cnt += 1
        else:
            nunu += temp[i][1]
            cnt += 1
    answer.append(nunu)

    for i in range(len(answer)):
        p = 0
        if answer[i] <= 0:
            answer[i] += 1439
        h = answer[i]
        if h // fees[0] == 0:
            p += fees[1]
            answer[i] = p
            continue
        else:
            p += fees[1]
            h -= fees[0]
            p += fees[3] * math.ceil(h / fees[2])
        answer[i] = p

    return answer