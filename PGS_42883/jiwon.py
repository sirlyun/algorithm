def solution(number, k):
    answer = []
    # 맨 앞의 숫자를 가장 크게 하는 것을 중점으로 하나씩 제거해나감(스택이용)
    for n in number:
        while answer and answer[-1] < n and k > 0:  # 제거횟수 남음? 정답 숫자 하나이상 있음? 가져온 숫자가 정답 맨뒤숫자보다 큼?
            k -= 1 # 제거 ㄱㄱ
            answer.pop()
        answer.append(n) # 나머지는 다 집어넣음

    return ''.join(answer[0:len(number) - k]) # 문자열로 변환