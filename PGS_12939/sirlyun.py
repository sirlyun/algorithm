'''
    문자열 s에는 공백으로 구분된 숫자들 저장
    최솟값과 최댓값을 찾아 반환
'''

def solution(s):
    # 받은 문자열을 리스트에 정수형으로 변환 후 저장
    num_list = list(map(int, s.split()))
    # 최댓값과 최솟값 찾기
    max_num = max(num_list)
    min_num = min(num_list)
    
    answer = str(min_num)+' '+str(max_num)
    return answer