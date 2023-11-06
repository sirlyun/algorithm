package algo_java.src;

import java.io.*;
import java.util.*;

/*
    집에서 학교까지 가는길은 MxN 크기의 격자로 나타낼 수 있다
    집은 (1, 1), 학교는 (M, N)에 위치
    물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles
    오른쪽과 아래쪽으로만 움직여
    집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return
 */

public class Main {
    static int[][] puddles = {{2, 2}};
    static int m, n;

    public static void main(String[] args) throws IOException {

        m = 4;
        n = 3;

        System.out.println(solution(n, m, puddles));

    }

    static int solution(int n, int m, int[][] puddles) {
        int[][] board = new int[n][m];

        for (int[] puddle : puddles){
            board[puddle[1]-1][puddle[0]-1] = -1;
        }

        board[0][0] = 1;
        // 아래쪽, 오른쪽 방향 설정
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                // 웅덩이라면 0으로 변환
                if(board[i][j] == -1) {
                    board[i][j] = 0;
                    continue;
                }
                // 경로 개수 갱신
                if(i != 0){
                    board[i][j] += board[i - 1][j] % 1000000007;
                }
                if(j != 0){
                    board[i][j] += board[i][j - 1] % 1000000007;
                }
            }
        }

        return board[n-1][m-1] % 1000000007;
    }

}

