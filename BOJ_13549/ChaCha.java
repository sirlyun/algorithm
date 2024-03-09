package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] arr = new int[100_001];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)
        // 수빈이는 걷거나 순간이동
        // 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동
        // 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동

        // 동생은 점 K(0 ≤ K ≤ 100,000)

        // 동생을 찾을 수 있는 가장 빠른 시간

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Arrays.fill(arr, Integer.MAX_VALUE);

        dijkstra(N);

        System.out.println(arr[K]);
    }

    private static void dijkstra(int start) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(com -> com[0]));
        queue.offer(new int[] {0, start});

        while (!queue.isEmpty()) {
            // time, coordinate
            int[] polled = queue.poll();

            int time = polled[0];
            int coordinate = polled[1];

            // 최소 시간 업데이트
            arr[coordinate] = Math.min(arr[coordinate], time);

            // + 1
            if (coordinate + 1 <= 100_000 && arr[coordinate + 1] > time + 1) {
                queue.offer(new int[] {time + 1, coordinate + 1});
            }
            // - 1
            if (0 <= coordinate - 1 && arr[coordinate - 1] > time + 1) {
                queue.offer(new int[] {time + 1, coordinate - 1});
            }
            // * 2
            if (coordinate * 2 <= 100_000 && arr[coordinate * 2] > time) {
                queue.offer(new int[] {time, coordinate * 2});
            }
        }
    }
}
