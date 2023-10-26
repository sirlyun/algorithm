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
    static int[][][] possible = {
            {{0, -1}, {1, 0}}, {{0, -1}, {-1, 0}}, {{-1, 0}, {0, 1}}, {{1, 0}, {0, 1}}
    };

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
                visited[n][m] = false;
            }
        }

        dfs(0);

        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();


    }

    static void dfs(int cnt){

        // 중심 정하기
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                // 중심이 아직 선택되지 않았을 때
                if (!visited[i][j]){
                    // 일단 중심 방문한 것으로 체크
                    visited[i][j] = true;
                    // 현재를 중심으로 했을 때 가능한 부메랑 모양 체크
                    for (int k=0; k<4; k++){
                        boolean flag = true;
                        List<Integer[]> chk = new ArrayList<>();
                        for (int l=0; l<2; l++){
                            int di = i + possible[k][l][0];
                            int dj = j + possible[k][l][1];
                            // 인덱스 범위를 넘어가면 현재 부메랑 모양으로 만들 수 없다
                            if (0>di || di>=N || 0>dj || dj>=M){
                                flag = false;
                                break;
                            }
                            else{
                                chk.add(new Integer[]{di, dj});
                                // 이미 방문한 곳이 현재 부메랑 모양에 포함되면 만들 수 없다
                                if (visited[di][dj]){
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        // 현재 부메랑 모양으로 만들 수 있을 때
                        if (flag){
                            // 부메랑 모양에 포함되는 곳들을 모두 방문 처리
                            visited[chk.get(0)[0]][chk.get(0)[1]] = true;
                            visited[chk.get(1)[0]][chk.get(1)[1]] = true;
                            // 계산해 가며 재귀
                            dfs(cnt + 2*board[i][j] + board[chk.get(0)[0]][chk.get(0)[1]] + board[chk.get(1)[0]][chk.get(1)[1]]);
                            visited[chk.get(0)[0]][chk.get(0)[1]] = false;
                            visited[chk.get(1)[0]][chk.get(1)[1]] = false;
                        }
                    }

                    visited[i][j] = false;
                }

            }
            // 최댓값 갱신
            if (i == N-1){
                result = Math.max(result, cnt);
            }
        }

    }



}