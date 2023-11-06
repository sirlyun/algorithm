def solution(m, n, puddles):

    mat = [[0] * m for _ in range(n)]
    visited = [[0] * m for _ in range(n)]
    
    # 물 웅덩이 1로 표시
    for i, j in puddles:
        mat[j - 1][i - 1] = 1
    # 왼쪽, 위 방향 선언    
    delta = [[-1, 0], [0, -1]]
    
    # 경우의 수 1부터 시작
    visited[0][0] = 1
    
    # 왼쪽, 위를 참고하면서 경우의 수 합치기
    for i in range(0, n):
        for j in range(0, m):
            for di, dj in delta:
                ni, nj = i + di, j + dj
                if 0 <= ni < n and 0 <= nj < m and mat[i][j] != 1:
                    visited[i][j] += visited[ni][nj]

    return visited[n-1][m-1] % 1000000007