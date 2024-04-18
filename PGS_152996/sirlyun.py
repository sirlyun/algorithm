'''
    중심으로부터 2, 3, 4 거리 지점에 좌석 하나씩 있음
    마주보고 탈 때 완전한 균형을 이루면 짝꿍임
'''
    
from collections import Counter

def solution(weights):
    answer = 0
    
    counter = Counter(weights)
    for k,v in counter.items():
        if v>=2:
            answer+= v*(v-1)//2
            
    weights = set(weights) 
    for w in weights:
        if w*2/3 in weights:
            answer += counter[w*2/3] * counter[w]
        if w*1/2 in weights:
            answer += counter[w*2/4] * counter[w]
        if w*3/4 in weights:
            answer += counter[w*3/4] * counter[w]
            
    return answer
