'''
    1. 각 기능은 진도가 100프로일 때 서비스에 반영 가능
    2. 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
    뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됨
    
    배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses
    각 작업의 개발 속도가 적힌 정수 배열 speeds
    각 배포마다 몇 개의 기능이 배포될까
'''

def solution(progresses, speeds):
    answer = []
    
    while progresses:
        cnt = 0
        while progresses and progresses[0] >= 100:
            cnt += 1
            progresses.pop(0)
            speeds.pop(0)

        progresses = [progresses[i]+speeds[i] for i in range(len(progresses))]

        if cnt:
            answer.append(cnt)
    
    return answer