'''
    모든 행성을 탐사하는데 걸리는 최소 시간
    탐색할 행성의 개수
    발사되는 행성의 위치
    행성 간 이동에 걸리는 시간
    2차원 행렬 i에서 j로 가는데 걸리는 시간이 i, j에 들어있다
    i와 j가 같을 때는 항상 0이 주어짐
    탐사 후 다시 시작 행성으로 안가도 되고 이미 방문한 행성도 중복해서 갈 수 있다

'''

def dfs(start, depth, chk):
    global result

    if depth == N:
        result = min(result, chk)
        return
    
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            dfs(i, depth+1, chk+time_arr[start][i])
            visited[i] = False
    

# 행성의 개수 N, 행성의 위치 K
N, K = map(int, input().split())
time_arr = [list(map(int, input().split())) for _ in range(N)]
visited = [False]*N
visited[K] = True
for k in range(N):
    for i in range(N):
        for j in range(N):
            time_arr[i][j] = min(time_arr[i][j], time_arr[i][k] + time_arr[k][j])

result = 1e9
dfs(K, 1, 0)

print(result)