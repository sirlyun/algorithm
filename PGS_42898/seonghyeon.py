def solution(m, n, puddles):

    # global visit

    visit = [[-1] * m for _ in range(n)]

    for puddle in puddles :

        pj = puddle[0] - 1
        pi = puddle[1] - 1

        visit[pi][pj] = 1e9

    def dfs(i, j):

        # global visit,n,m

        if i == n - 1 and j == m - 1:
            return 1

        if visit[i][j] != -1:
            return visit[i][j]

        visit[i][j] = 0

        for di, dj in ((0, 1), (1, 0)):

            ni = i + di
            nj = j + dj

            if 0 <= ni < n and 0 <= nj < m and visit[ni][nj] != 1e9:

                visit[i][j] += dfs(ni, nj)

        return visit[i][j]
    
    dfs(0, 0)

    answer = visit[0][0] % 1000000007

    return answer

m = 4
n = 3
puddles = [[2, 2]]

print(solution(m,n,puddles))