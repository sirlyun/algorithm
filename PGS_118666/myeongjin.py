def solution(survey, choices):
    answer = ''
    N = len(survey)

    per_type = [[0, 0] for _ in range(4)] # 성격 유형 (RT, CF, JM, AN)
    for i in range(N):

        result, idx = indicator(survey[i], choices[i]) # [x, y] 점수, 지표번호
        per_type[idx][0] += result[0]
        per_type[idx][1] += result[1]

    for j in range(4): # per_type을 돌면서 
        L = indic[j][0]
        R = indic[j][1]

        if per_type[j][0] >= per_type[j][1]: # 같거나 크면 왼쪽 : RT 중 왼쪽 거
            answer += L
        else: # 작으면 오른쪽 : RT 중 오른쪽 거
            answer += R

    return answer


def indicator(string, choice):
    no_agr = string[0] # 비동의 성격 유형
    agr = string[1] # 동의 성격 유형

    select_indic = 0 # 선택된 지표
    score = [0, 0] # 점수
    for i in range(4): # 정, 역배열에 따라 0과 1만 바뀜
        if no_agr + agr == indic[i]: # 정해놓은 지표 '정배열'
            select_indic = i
            if choice == 1 or choice == 2 or choice == 3:
                score[0] = 4 - choice

            elif choice == 5 or choice == 6 or choice == 7:
                score[1] = choice - 4

        elif no_agr + agr == indic[i][::-1]: # 정해놓은 지표 '역배열'
            select_indic = i
            if choice == 1 or choice == 2 or choice == 3:
                score[1] = 4 - choice

            elif choice == 5 or choice == 6 or choice == 7:
                score[0] = choice - 4

    return score, select_indic


indic = ['RT', 'CF', 'JM', 'AN'] # 성격 유형 지표

