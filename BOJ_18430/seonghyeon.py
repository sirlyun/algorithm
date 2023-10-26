def dfs(x,strength) :

    global ans

    for i in range(x,N) :

        for j in range(M) :

            if visited[i][j] == 0 :

                for boo in boos :

                    i11, i12 = i + boo[0][0], j + boo[0][1]
                    i21, i22 = i + boo[1][0], j + boo[1][1]

                    if 0 <= i11 < N and 0 <= i12 < M and 0 <= i21 < N and 0 <= i22 < M :

                        if visited[i11][i12] == 0 and visited[i21][i22] == 0 :

                            visited[i][j] = 1
                            visited[i11][i12] = 1
                            visited[i21][i22] = 1

                            dfs(i,strength + arr[i][j] * 2 + arr[i11][i12] + arr[i21][i22])

                            visited[i][j] = 0
                            visited[i11][i12] = 0
                            visited[i21][i22] = 0

    else :

        ans = max(ans,strength)
        return

N, M = map(int,input().split())

arr = [list(map(int,input().split())) for _ in range(N)]

boos = [
    [[0,-1],[1,0]], # 1
    [[0,-1],[-1,0]], # 2
    [[0,1],[-1,0]], # 3
    [[0,1],[1,0]] # 4
]

visited = [[0] * M for _ in range(N)]
ans = 0
dfs(0,0)

print(ans)