package algo_java.src;

import java.io.*;
import java.util.*;

/*
    부메랑 제작을 위한 고급 재료는 NxM 크기의 직사각형 형태
    부위마다 강도가 조금씩 다르다
 */

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 부매랑 재료 만들기
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for (int m=0; m<M; m++){
                board[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();


    }

    static void dfs(int idx, int cnt){

        // 중심 정하기
        for (int i=idx; i<N; i++){
            for (int j=0; j<M; j++){
                // 중심이 아직 선택되지 않았을 때
                if (!visited[i][j]){
                    // 현재를 중심으로 했을 때 가능한 부메랑 모양 체크
                    for (int k=0; k<4; k++){
                        int di1 = i + dx[k];
                        int dj1 = j + dy[k];

                        int di2 = i + dx[(k+1)%4];
                        int dj2 = j + dy[(k+1)%4];

                        if (0<=di1 && 0<=di2 && 0<=dj1 && 0<=dj2 && di1<N && di2<N && dj1<M && dj2<M){
                            if (!visited[di1][dj1] && !visited[di2][dj2]){
                                visited[i][j] = true;
                                visited[di1][dj1] = true;
                                visited[di2][dj2] = true;
                                // 계산해 가며 재귀
                                dfs(i, cnt + 2*board[i][j] + board[di1][dj1] + board[di2][dj2]);
                                visited[i][j] = false;
                                visited[di1][dj1] = false;
                                visited[di2][dj2] = false;
                            }
                        }
                    }
                }
            }
        }
        result = Math.max(result, cnt);

    }

}