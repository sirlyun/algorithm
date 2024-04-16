'''
    자카드 유사도
        두 집합 A, B 사이의 자카드 유사도 J(A, B)는
        두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값
    두 글자씩 끊어서 다중집합의 원소로 만든다
'''

from collections import Counter

def solution(str1, str2):
    answer = 0
    str1_low = str1.lower()
    str2_low = str2.lower()
    
    str1_list = []
    str2_list = []
    
    for i in range(1, len(str1_low)):
        if str1_low[i-1].isalpha() and str1_low[i].isalpha():
            str1_list.append(str1_low[i-1] + str1_low[i])
    for j in range(1, len(str2_low)):
        if str2_low[j-1].isalpha() and str2_low[j].isalpha():
            str2_list.append(str2_low[j-1] + str2_low[j])
            
    Counter1 = Counter(str1_list)
    Counter2 = Counter(str2_list)
    
    inter = list((Counter1 & Counter2).elements())
    union = list((Counter1 | Counter2).elements())
    
    if len(union) == 0 and len(inter) == 0:
        return 65536
    else:
        return int(len(inter) / len(union) * 65536)