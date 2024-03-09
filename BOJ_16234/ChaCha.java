package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, L, R;
    private static int[][] arr;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int answer = 0;
    private static boolean[][] isVisited;
    private static Map<Integer, List<int[]>> map;

    public static void main(String[] args) throws IOException {
        // 입력
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int nn = 1; nn <= N; nn++) {
                arr[n][nn] = Integer.parseInt(st.nextToken());
            }
        }

        // 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
        // 위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.

        // 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
        // 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.

        // 연합을 해체하고, 모든 국경선을 닫는다.

        // 인구 이동이 며칠 동안 발생하는지

        while (true) {
            // 국경 열기
            long result = openBorder();

            if (result > 0) {
                // 인구 이동
                // map 순회하면서

                map.entrySet().forEach((es) -> {
                    int total;

                    List<int[]> list = es.getValue();

                    if (list.size() > 1) {
                        total = list.stream().mapToInt(l -> arr[l[0]][l[1]]).sum();

                        int distribution = total / list.size();

                        list.forEach(l -> arr[l[0]][l[1]] = distribution);
                    }
                });

                answer += 1;
            }
            // 열린 국경이 없으면
            else {
                // 끝
                break;
            }
        }

        System.out.println(answer);
    }

    private static long openBorder() {
        int unionId = 0;
        map = new HashMap<>();
        isVisited = new boolean[N + 1][N + 1];

        // 처음부터 끝까지 확인할건데
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 이미 확인했으면 다음거
                if (isVisited[i][j]) {
                    continue;
                }

                // bfs 할거임
                bfs(i ,j, unionId);

                unionId += 1;
            }
        }
        
        return map.entrySet().stream().filter((en) -> en.getValue().size() > 1).count();
    }

    private static void bfs(int y, int x, int unionId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();

            int i = polled[0];
            int j = polled[1];

            // map에 이미 있으면
            if (map.containsKey(unionId)) {
                map.get(unionId).add(new int[] {i, j});
            }
            else {
                List<int[]> temp = new LinkedList<>();
                temp.add(new int[] {i, j});
                map.put(unionId, temp);
            }

            isVisited[i][j] = true;

            for (int a = 0; a < 4; a++) {
                int newY = i + dy[a];
                int newX = j + dx[a];

                // 범위 넘으면
                if (newY <= 0 || newY > N || newX <= 0 || newX > N) {
                    // 꺼져
                    continue;
                }

                // 이미 방문했으면
                if (isVisited[newY][newX]) {
                    // 꺼져
                    continue;
                }

                int diff = Math.abs(arr[i][j] - arr[newY][newX]);

                if (L <= diff && diff <= R) {
                    isVisited[newY][newX] = true;
                    queue.offer(new int[] {newY, newX});
                }
            }
        }
    }
}
