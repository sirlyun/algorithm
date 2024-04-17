'''
    다리를 정해진 순으로 건너기
    모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는가
    
    다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며
    다리는 weight 이하까지의 무대를 견딜 수 있음
    다리에 완전히 오르지 않은 트럭의 무게는 무시
    
    모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 반환
'''

from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    
    # 다리를 건너는 트럭
    bridge = deque()
    time = deque()
    # 다리 건너기
    while bridge or truck_weights:
        # 시간 지나기
        answer += 1
        for t in range(len(time)):
            time[t] += 1
        # 다리 지나기
        if bridge:
            # 다리를 모두 건넜을 경우
            if time[0] == bridge_length:
                bridge.popleft()
                time.popleft()
        if truck_weights:
            # 트럭이 다리에 올라설 수 있는 경우
            if len(bridge)+1 <= bridge_length and sum(bridge)+truck_weights[0] <= weight:
                bridge.append(truck_weights.pop(0))
                time.append(0)
    
    return answer