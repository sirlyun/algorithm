def solution(survey, choices):
    answer = ''
    
    # 딕셔너리 만들기
    dic = dict(zip(['R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'], [0] * 8))
    
    # choices 정규화
    choices = list(map(lambda x: x-4, choices))
    
    # 딕셔너리에 점수 저장
    for i in range(len(choices)):
        if choices[i] < 0:
            dic[survey[i][0]] += abs(choices[i])
        elif choices[i] > 0:
            dic[survey[i][1]] += abs(choices[i])
        else:
            pass
    
    # 점수 비교, 검사 출력
    for a, b in [['R', 'T'], ['C', 'F'], ['J', 'M'], ['A', 'N']]:
        if dic[a] >= dic[b]:
            answer += a
        else:
            answer += b
        
    return answer