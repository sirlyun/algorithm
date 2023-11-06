def solution(m, n, puddles):
    arr = [[0] * m for _ in range(n)]

    for i, j in puddles:
        # m,n 반대
        arr[j - 1][i - 1] = 'x'

    visited = [[-1] * m for _ in range(n)]

    def f(i, j):
        if i == n - 1 and j == m - 1:
            return 1

        if visited[i][j] != -1:
            return visited[i][j]

        visited[i][j] = 0

        for di, dj in [[0, 1], [1, 0]]:
            ni = i + di
            nj = j + dj
            if ni < 0 or ni >= n or nj < 0 or nj >= m:
                continue
            # 물웅덩이 있으면
            if arr[ni][nj] == 'x':
                continue

            visited[i][j] += f(ni, nj)

        return visited[i][j]

    # 0,0 출발
    f(0, 0)

    return visited[0][0] % 1000000007