'''
   관리 규칙
    1. 실행 대기 큐에서 대기중인 프로세스 하나 꺼내기
    2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 꺼낸거 다시 넣기
    3. 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행
        3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료
'''

def solution(priorities, location):
    answer = 0
    
    process = [i for i in range(len(priorities))]
    cnt = 0
    
    while True:
        now, now_pri = process.pop(0), priorities.pop(0)
        
        for pri in priorities:
            # 더 우선순위가 높은 프로세스가 있는 경우
            if now_pri < pri:
                process.append(now)
                priorities.append(now_pri)
                break
        # 더 우선순위가 높은 프로세스가 없는 경우
        else:
            cnt += 1
            if now == location:
                answer = cnt
                break
    
    return answer