'''
    튜플의 성질
        1. 중복 원소 가능
        2. 원소에 순서가 있음
        3. 원소 개수 유한
'''

def solution(s):
    answer = []
    input_string = s.split('},')
    tmp = []
    
    for i in input_string:
        tmp.append(i.replace('{', '').replace('}', '').split(','))
    tmp.sort(key=len)
    
    for i in tmp:
        for j in i:
            if int(j) not in answer:
                answer.append(int(j))
    
    return answer