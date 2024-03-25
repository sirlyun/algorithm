package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    private static int N, M;
    private static List<int[]>[] list;
    private static int[] map;

    public static void main(String[] args) throws IOException {
        // 입력
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        map = new int[N + 1];
        Arrays.fill(map, Integer.MAX_VALUE);

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[from].add(new int[] {to, cost});
            list[to].add(new int[] {from, cost});
        }

        bfs();

        System.out.println(map[N]);
    }

    private static void bfs() {
        Deque<Integer> queue = new ArrayDeque<>();

        map[1] = 0;

        // to, cost
        queue.offerLast(1);

        while (!queue.isEmpty()) {
            int current = queue.pollFirst();

            // 여기서 갈 수 있는 것들 추가
            for (int[] element : list[current]) {
                int nextPoint = element[0];
                int nextCost = element[1];

                int newCost = map[current] + nextCost;

                // 갈 곳의 기존 비용보다 적으면
                if (newCost < map[nextPoint]) {
                    map[nextPoint] = newCost;
                    queue.offerLast(nextPoint);
                }
            }
        }
    }
}
