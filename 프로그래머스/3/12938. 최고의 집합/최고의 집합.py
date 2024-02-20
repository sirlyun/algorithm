'''
    각 원소의 합이 S가 되는 수이면서
    각 원소의 곱이 최대가 되는 집합
'''

def solution(n, s):
    answer = []
    
    if s<n:
        return [-1]
    
    num = s // n
    rest = s % n
    
    for i in range(n):
        answer.append(num)
    
    if rest != 0:
        for a in range(len(answer)):
            answer[a] += 1
            rest -= 1
            if rest == 0:
                break
        answer.sort()
        return answer
    
    return answer