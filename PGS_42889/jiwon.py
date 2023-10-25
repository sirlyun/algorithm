

def solution(N, stages):
    # 실패율이 높은 스테이지부터 내림차순으로 스테이지 번호 배열 리턴
    # 실패율 = 스테이지 도달했지만 클리어x / 스테이지 도달
    lst = []    # 스테이지 번호와 실패율 저장 위한 리스트
    s = len(stages) # 스테이지 도달한 사람
    for i in range(1, N+1):
        not_clear = stages.count(i) # 스테이지 도달했지만 클리어 못한 사람
        if s != 0:
            fail = not_clear / s    # 실패율 계산
        else:
            fail = 0
        lst.append((i,fail))    # 스테이지 번호와 실패율 묶어서 저장
        s -= not_clear  # 전체개수에서 해당스테이지 클리어 못한 사람들을 모두 제외

    lst.sort(key=lambda x: (-x[1],x[0]))  # 실패율이 높은 순, 실패율 같으면 스테이지 번호 작은 순
    answer = []
    for i in lst:
        answer.append(i[0]) # 스테이지 번호만 저장
    return answer
