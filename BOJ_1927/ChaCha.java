package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    private static Queue<Long> pq = new PriorityQueue<>();
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            Long input = Long.parseLong(br.readLine());

            // 빼라
            if (input == 0) {
                // pq에 뭔가 있을 때
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            else {
                pq.offer(input);
            }
        }

        System.out.println(sb);
    }
}
