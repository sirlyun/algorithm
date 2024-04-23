'''
    양의 정수 n
    n을 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수가 몇개인가
        0P0처럼 소수 양쪽에 0이 있는 경우
        P0처럼 소수 오른쪽에만 0이 있고, 왼쪽에는 아무것도 없는 경우
        0P처럼 소수 왼쪽에만 0이 있고, 오른쪽에는 아무것도 없는 경우
        P처럼 소수 양쪽에 아무것도 없는 경우
        단, P는 각 자릿수에 0을 포함하지 않는 소수
'''

def make_k(n, k):
    tmp = ''
    
    while n > 0:
        n, mod = divmod(n, k)
        tmp += str(mod)
        
    return tmp[::-1]

def check_prime(check):
    N = int(check)
    
    if N == 1:
        return False
    for n in range(2, int(N**0.5)+1):
        if N % n == 0:
            return False
    return True

def solution(n, k):
    answer = 0
    
    # k진수로 변환
    if k != 10:
        new_n = make_k(n, k)
    else:
        new_n = str(n)
    # 조건에 맞는 숫자 찾기
    check_n = new_n.split('0')
    # 소수 체크
    for check in check_n:
        if check == '':
            continue
        if check_prime(check):
            answer += 1
    
    return answer