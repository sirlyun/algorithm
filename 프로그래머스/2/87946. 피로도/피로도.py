'''
    일정 피로도를 소모해 던전 탐험
    각 던전마다 탐험을 시작하기 위해 필요한 최소 필요도가 있음
    각 던전마다 탐험을 마친 후 소모되는 소모 피로도가 있음
    
    하루에 한 번씩 탐험할 수 있는 던전이 여러 개 있음
    탐험 할 수 있는 최대 던전 수는?
'''

answer = -1
d_len = -1

def dfs(life, depth, visited, dungeons):
    global answer
    
    answer = max(answer, depth)
    for i in range(d_len):
        if not visited[i] and life >= dungeons[i][0]:
            visited[i] = True
            dfs(life-dungeons[i][1], depth+1, visited, dungeons)
            visited[i] = False
    
def solution(k, dungeons):
    global d_len
    
    d_len = len(dungeons)
    visited = [False]*d_len
    dfs(k, 0, visited, dungeons)
    
    return answer