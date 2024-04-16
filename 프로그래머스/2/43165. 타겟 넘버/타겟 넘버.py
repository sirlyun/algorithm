'''
    보유한 정수들에 더하기나 빼기를 활용해서 타겟 넘버를 만들기
    만들 수 있는 방법의 수는?
'''

answer = 0

def dfs(depth, cnt, numbers, target):
    global answer
    
    if depth == len(numbers):
        if cnt == target:
            answer += 1
        return

    dfs(depth+1, cnt+numbers[depth], numbers, target)
    dfs(depth+1, cnt-numbers[depth], numbers, target)
    
def solution(numbers, target):
    global answer
    
    dfs(0, 0, numbers, target)
    
    return answer