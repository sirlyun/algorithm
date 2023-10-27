def solution(survey, choices):

    answer = ''
    type = ['RT','TR','CF','FC','JM','MJ','AN','NA']
    score = [[0,0] for _ in range(8)]

    for i in range(len(survey)):

        type_idx = type.index(survey[i])

        if choices[i] <= 3:
            score[type_idx][0] += 4 - choices[i]
        elif choices[i] >= 5:
            score[type_idx][1] += choices[i] - 4

    final_score = [[0,0] for _ in range(4)]
    type2 = ['RT','CF','JM','AN']
    for i in range(4):
        final_score[i][0] = score[i*2][0] + score[i*2+1][1]
        final_score[i][1] = score[i*2][1] + score[i*2+1][0]

    for i in range(4):
        if final_score[i][0] > final_score[i][1]:
            answer += type2[i][0]
        elif final_score[i][0] < final_score[i][1]:
            answer += type2[i][1]
        else:
            if i == 0:
                answer += 'R'
            elif i == 1:
                answer += 'C'
            elif i == 2:
                answer += 'J'
            else:
                answer += 'A'

    return answer