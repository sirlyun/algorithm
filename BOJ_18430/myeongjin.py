def dfs(x, strength):
    global max_strength

    for i in range(x, N): # x 백트래킹 : 중간 부메랑을 볼 때 처음 것과 겹쳐 시간초과 발생
        for j in range(M):

            if visited[i][j] == 0:
                mid_str = arr[i][j]
                for k in range(4): # 돌아가면서 2개씩 본다.
                    if k == 3:
                        k = -1
                    ci1, cj1 = i+di[k], j+dj[k]
                    ci2, cj2 = i+di[k+1], j+dj[k+1]

                    if 0 <= ci1 < N and 0 <= cj1 < M and 0 <= ci2 < N and 0 <= cj2 < M:
                        if visited[ci1][cj1] == 0 and visited[ci2][cj2] == 0: # 부메랑 만들면 방문 처리
                            visited[i][j] = 1
                            visited[ci1][cj1] = 1
                            visited[ci2][cj2] = 1
                            dfs(i, strength + 2 * mid_str + arr[ci1][cj1] + arr[ci2][cj2]) # 점수 계산
                            visited[i][j] = 0 # 초기화
                            visited[ci1][cj1] = 0
                            visited[ci2][cj2] = 0
    # 다 돌면 max 계산
    else:
        max_strength = max(max_strength, strength)
        return


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# 부메랑 만들기 (좌하, 좌상, 우상, 우하)
di = [0, 1, 0, -1] # 01좌하 12우하 23우상 34좌상
dj = [-1, 0, 1, 0]
visited = [[0] * M for _ in range(N)]
max_strength = 0
dfs(0, 0)
print(max_strength)