'''
    JadenCase
        첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열
        단, 첫 문자가 알파벳이 아닐 때 이어지는 알파벳은 소문자로 쓰기
    s를 JadenCase로 바꾼 문자열을 반환
'''

def solution(s):
    answer = ''
    arr = s.split(' ')
    
    for a in range(len(arr)):
        if arr[a]:
            answer += arr[a][0].upper() + arr[a][1:].lower()
        else:
            answer += arr[a]
        
        if a != len(arr)-1:
            answer += ' '
            
    return answer