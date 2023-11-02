from collections import deque

def solution(number, k):
    
    number = deque(map(int, number))
    stack = deque()
    
    while True:
        if not stack:
            stack.append(number.popleft())
        
        else:
            # 높은 자릿수 < 낮은 자릿수 이고, k가 남아있으면 높은 자릿수를 지우기
            if stack[-1] < number[0]:
                stack.pop()
                k -= 1
            # 아니면 스택에 넣고 나중에 비교하기
            else:
                stack.append(number.popleft())
        
        # k를 다 썼거나 k가 남아있지만 number를 다 썼으면 break 
        if not number or k == 0:
            break
    
    # k가 남아있으면 그만큼 pop
    if k > 0:
        for _ in range(k):
            stack.pop()
    
    
    return "".join(map(str, stack + number))