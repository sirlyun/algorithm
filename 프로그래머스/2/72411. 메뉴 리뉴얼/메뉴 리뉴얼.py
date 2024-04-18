'''
    손님들이 가장 많이 함께 주문한 단품들을 코스요리로 구성
    코스요리 제약
        - 최소 2가지 이상의 단품 구성
        - 최소 2명 이상의 손님으로부터 주문된 조합에 대해서만 메뉴 후보 포함
    새로 추가하게 될 코스요리의 메뉴 구성을 반환
    사전 순으로 오름차순 정렬
'''

from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    
    for k in course:
        candidates = []
        for menu_li in orders:
            for li in combinations(menu_li, k):
                res = ''.join(sorted(li))
                candidates.append(res)
        sorted_candidates = Counter(candidates).most_common()
        answer += [menu for menu, cnt in sorted_candidates if cnt > 1 and cnt == sorted_candidates[0][1]]
        
    return sorted(answer)