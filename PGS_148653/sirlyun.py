'''
    10의 제곱수 형태인 정수들이 적힌 버튼
    버튼 누르면 현재 층수 + 버튼 층수 로 이동
    단, 더한 결과가 0보다 작으면 이동하지 않음
    0층이 최하층이고 엘베는 현재 사용자 층에 있음
    
    버튼 한번당 마법의 돌 한 개 소모
    최소한의 버튼 클릭으로 0층 이동
'''

def solution(storey):
    answer = 0
    
    while storey:
        remain = storey % 10
        
        if remain > 5:
            answer += 10 - remain
            storey += 10
        elif remain < 5:
            answer += remain
        else:
            if (storey//10) % 10 > 4:
                storey += 10
            answer += remain
        storey //= 10
    
    return answer