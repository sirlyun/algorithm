'''
실패율 : 스테이지 도달했으나 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수

N : 전체 스테이지 개수
stages : 사용자가 현재 멈춰있는 스테이지 번호가 담긴 배열

실패율 높은 스테이지부터 내림차순으로 스테이지 번호 담아서 return
같으면 작은 번호 먼저

N : 1~500
len(stages) : 1~200000
stages[i] : 1~N+1
스테이지에 도달한 유저가 없으면 해당 스테이지 실패율 : 0

N+1은 마지막까지 클리어한 도전자

'''

def solution(N, stages):
    
    players = len(stages)
    
    counts = [0] * (N + 2)
    left_players = [players] * (N + 2)
    for x in stages: 
        counts[x] += 1
    
    for i in range(1, N + 1):
        left_players[i + 1] = left_players[i] - counts[i]
    
    # i번째 스테이지 실패율, 
    fail_rates = [[i, 0] for i in range(1, N + 1)]
    for i in range(N):
        if left_players[i+1]:
            fail_rates[i][1] = counts[i+1]/left_players[i+1]
    
    fail_rates.sort(key=lambda x: [-x[1], x[0]])
    
    answer = []
    for fail_rate in fail_rates:
        answer.append(fail_rate[0])
        
    print(answer)
    
    return answer