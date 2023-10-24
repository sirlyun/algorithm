package algo_java.src;

import java.io.*;
import java.nio.Buffer;
import java.util.*;
/*
    처음에는 시작 칸에 말 4개가 있다
    말은 게임판에 그려진 화살표의 방향대로만 이동할 수 있다.
    말이 파란색 칸에서 이동을 시작하면 파란색 화살표를 타야 하고, 이동하는 도중이거나 파란색이 아닌 칸에서 이동을 시작하면 빨간색 화살표를 타야 한다.
    말이 도착 칸으로 이동하면 주사위에 나온 수와 관계 없이 이동을 마친다.
    게임은 10개의 턴으로 이루어진다.
    매턴마다 5면체 주사위를 굴리고 도착 칸에 있지 않은 말을 하나 골라 주사위 나온 눈만큼 이동시킨다.
    말이 이동을 마치는 칸에 말이 있으면 그 말을 고를 수 없다
        단 이동을 마치는 칸이 도착 칸이면 고를 수 있다
    말이 이동을 마칠 때마다 칸에 적혀있는 점수를 얻는다.
    주사위에서 나올 수 10개를 미리 알고 있을 때, 얻을 수 있는 점수의 최댓값을 구해보자.
 */

public class Main {

    static List<Integer> numList;
    // 게임판 만들기
    static int[][] board = {
            {1}, {2}, {3}, {4}, {5}, {6, 21}, {7}, {8}, {9}, {10},
            {11, 25}, {12}, {13}, {14}, {15}, {16, 27}, {17}, {18},
            {19}, {20}, {32}, {22}, {23}, {24}, {30}, {26}, {24}, {28},
            {29}, {24}, {31}, {20}, {32}
    };
    static int[] scoreBoard = {
            0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20,
            22, 24, 26, 28, 30, 32, 34, 36, 38, 40,
            13, 16, 19, 25, 22, 24, 28, 27, 26, 30, 35, 0
    };
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        // 주사위에서 나올 수 10개를 담는 리스트
        numList = new ArrayList<>();
        for (int i=0; i<10; i++){
            int num = Integer.parseInt(st.nextToken());
            numList.add(num);
        }

        // 4개의 말 위치
        int[] chk = {0, 0, 0, 0};

        dfs(chk, 0, 0);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();

    }

    static void dfs(int[] chk, int depth, int score){

        // 주사위 모두 굴리면 끝
        if (depth == 10){
            if (answer < score){
                answer = score;
            }
            return;
        }

        // 말 이동
        for (int i=0; i<4; i++){
            // 현재 말 위치
            int now = chk[i];
            // 게임판 현재 위치에서 갈 수 있는 곳 체크해서 방향 설정
            if (board[now].length == 2){
                now = board[now][1];
            }
            else {
                now = board[now][0];
            }
            // 방향 설정하면서 하나 이동한거 제외하고 나머지 이동
            for (int j=1; j<numList.get(depth); j++){
                now = board[now][0];
            }
            // 이동한 곳에 말이 있는지 체크
            boolean check = false;
            for (int k=0; k<4; k++){
                if (now == chk[k]){
                    check = true;
                    break;
                }
            }
            // 백트래킹
            if (now==32 || (now<32 && !check)){
                int before = chk[i];
                chk[i] = now;
                dfs(chk, depth+1, score+scoreBoard[now]);
                chk[i] = before;
            }
        }

    }
}