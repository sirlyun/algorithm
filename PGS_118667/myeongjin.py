from collections import deque

def solution(queue1, queue2):
    answer = -2
    
    q1 = deque()
    q2 = deque()
    L = len(queue1)
    
    flag1 = 0 # 모두 짝수면 0
    flag2 = 0
    for i in range(L):
        q1.append(queue1[i])
        q2.append(queue2[i])
        
        if queue1[i] % 2 == 1:
            flag1 = 1
        
        if queue2[i] % 2 == 1:
            flag2 = 1
        
    # 총 합의 평균을 계산
    sum1 = sum(q1)
    sum2 = sum(q2)
    sum_num = sum(q1)+sum(q2)
    avg = sum_num/2
    
    # 평균보다 값이 큰 경우
    if avg < max(q1) or avg < max(q2):
        return -1
    
    # 원소가 모두 짝수인데, 평균이 홀수일 때
    if flag1 == 0 and flag2 == 0 and avg % 2 == 1:
        return -1
    
    count = 0
    # 짝수면 큰 것에서 작은 것 넣기
    if sum_num % 2 == 0:
        
        # 같으면 횟수는 0
        if sum1 == sum2:
            return 0
        
        while sum1 != sum2:

            if sum1 > sum2:
                tg = q1.popleft()
                q2.append(tg)
                sum1 -= tg
                sum2 += tg
                count += 1

            elif sum1 < sum2:
                tg = q2.popleft()
                q1.append(tg)
                sum1 += tg
                sum2 -= tg
                count += 1
            # 개같당.. 조건 다 찾고 있었넹
            if count == 3 * L:
                return -1

        answer = count
        return answer
    # 홀수면, -1 반환
    else:
        return -1