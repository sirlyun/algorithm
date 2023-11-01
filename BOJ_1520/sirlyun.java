package algo_java.src;

import java.io.*;
import java.util.*;

/*
    NxM 크기의 지도
    각 칸에는 그 지점의 높이가 적혀있다
    지점 사이의 이동은 상하좌우 이웃
    (0, 0)에서 (N-1, M-1)로 이동하는데
    내리막길로만 이동하는 경로의 개수 출력

    dfs?
 */

public class Main {

    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp = new int[N][M];

        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for (int m=0; m<M; m++){
                board[n][m] = Integer.parseInt(st.nextToken());
                dp[n][m] = -1;
            }
        }


        bw.write(Integer.toString(dfs(0, 0)));
        bw.flush();
        bw.close();
    }

    static int dfs(int startX, int startY){
        if (startX == N-1 && startY == M-1){
            return 1;
        }

        if (dp[startX][startY] != -1){
            return dp[startX][startY];
        }

        dp[startX][startY] = 0;
        for (int i=0; i<4; i++){
            int di = startX + dx[i];
            int dj = startY + dy[i];
            if (0<=di && di<N && 0<=dj && dj<M){
                if (board[startX][startY] > board[di][dj]){
                    dp[startX][startY] += dfs(di, dj);
                }
            }
        }

        return dp[startX][startY];
    }
}

