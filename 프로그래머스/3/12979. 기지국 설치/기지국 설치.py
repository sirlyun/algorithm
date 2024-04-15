'''
    일렬인 N개의 아파트
    일부 아파트에는 4g 기지국 설치
    4g -> 5g 변경
    5g는 4g보다 전파 전달 범위가 좁음
    전파의 도달 거리가 w일 때 설치된 아파트 기준으로 양쪽 w만큼 전달 가능
    최소로 설치하면서 모든 아파트에 전파 전달
'''

import math

def solution(n, stations, w):
    answer = 0
    
    cover = w*2 + 1
    # 커버 안되는 구간들
    yet = []
    # 기지국 사이 사이
    for s in range(1, len(stations)):
        yet.append((stations[s]-w-1) - (stations[s-1]+w))
    # 시작점부터 첫 기지국 사이
    yet.append(stations[0]-w-1)
    # 마지막 기지국부터 끝점 사이
    yet.append(n-(stations[-1]+w))
    
    for i in yet:
        if i <= 0:
            continue
        answer += math.ceil(i / (2*w+1))

    return answer