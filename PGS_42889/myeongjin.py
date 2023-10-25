import copy

def solution(N, stages):
    flag = 0
    
    L = len(stages)
    result = []
    for i in range(1, N + 1):
        cnt = stages.count(i)
        if L > 0: # 실패율 삽입
            result.append(cnt / L)
            L -= cnt
        elif L == 0: # 끝 스테이지에 도달하기 전에 L이 0이 되는 경우
            result.append(L) # 0 삽입

    answer = []
    result_co = copy.deepcopy(result)
    result_co.sort(reverse=True) # 내림차순 정렬

    visited = [0] * len(result)

    for j in range(len(result_co)): # 제일 큰 것부터 하나씩 보면서
        for k in range(len(result)): # 찾아나간다.
            if visited[k] == 0 and result_co[j] == result[k]: # 방문 안했고 같으면
                visited[k] = 1 # 방문처리하고
                answer.append(k+1) # idx + 1 추가

    return answer

