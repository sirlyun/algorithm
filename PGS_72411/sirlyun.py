'''
    손님들이 가장 많이 함께 주문한 단품들을 코스요리로 구성
    코스요리 제약
        - 최소 2가지 이상의 단품 구성
        - 최소 2명 이상의 손님으로부터 주문된 조합에 대해서만 메뉴 후보 포함
    새로 추가하게 될 코스요리의 메뉴 구성을 반환
    사전 순으로 오름차순 정렬
'''

from itertools import combinations

def solution(orders, course):
    answer = []
    
    count_dict = {}
    
    for c in course:
        for order in orders:
            tmp = combinations(order, c)
            for t in tmp:
                chk = ''.join(sorted(t))
                count_dict.setdefault(chk, 0)
                count_dict[chk] += 1
    sorted_count_dict = sorted(count_dict.items(), key=lambda item: -item[1])
    
    standard_key = ''
    standard_value = 0
    for item in sorted_count_dict:
        key = item[0]
        value = item[1]
        if len(key) > len(standard_key):
            standard_key = key
            standard_value = value
        if value >= 2 and value == standard_value:
            answer.append(key)
    
    return sorted(answer)