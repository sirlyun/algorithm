'''
    규칙
        1. 자연수만 존재
        2. 모든 수를 표현할 때 1, 2, 4 만 사용
    3진법 느낌?
    1, 2, 4 -> 3 * 1
    11, 12, 14, 21, 22, 24, 41, 42, 44 -> 3 * 2
    111, 112, ... -> 3 * 3
'''

def solution(n):
    answer = []
    
    while n:
        t = n % 3
        if not t:
            t = 4
            n -= 1
        answer.append(str(t))
        n //= 3
        
    return ''.join(answer[::-1])