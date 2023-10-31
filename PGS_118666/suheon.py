'''
딕셔너리 -> .items() -> list
'''


def solution(survey, choices):
    answer = ''
    cha = {'R': 0, 'T': 0, 'C': 0, 'F': 0,
           'J': 0, 'M': 0, 'A': 0, 'N': 0}
    leng = len(survey)

    for i in range(leng):
        X = survey[i][0]
        Y = survey[i][1]

        if choices[i] == 4:
            pass
        elif choices[i] < 4:
            cha[X] += 4 - choices[i]
        else:
            cha[Y] += choices[i] - 4

    lst = list(cha.items())
    print(lst)
    for i in range(0, 7, 2):
        if lst[i][1] >= lst[i + 1][1]:
            answer += lst[i][0]
        else:
            answer += lst[i + 1][0]

    return answer