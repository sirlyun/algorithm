package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map, shortest;
    private static int firstX, firstY, N, M;
    private static StringBuffer sb = new StringBuffer();
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        shortest = new int[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());

                if (map[n][m] == 2) {
                    firstX = m;
                    firstY = n;
                }
            }
        }

        bfs(firstX, firstY);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && shortest[i][j] == 0) {
                    sb.append(-1).append(" ");
                }
                else {
                    sb.append(shortest[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int firstX, int firstY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {firstX, firstY});

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = polled[0] + dx[i];
                int newY = polled[1] + dy[i];

                // 밖으로 나가면 꺼져
                if (newX < 0 || newX >= M || newY < 0 || newY >= N) {
                    continue;
                }

                // 갈 수 없는 곳이면 꺼져
                if (map[newY][newX] != 1) {
                    continue;
                }

                int newValue = shortest[polled[1]][polled[0]] + 1;
                if (shortest[newY][newX] == 0 || newValue < shortest[newY][newX]) {
                    shortest[newY][newX] = newValue;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
    }
}

