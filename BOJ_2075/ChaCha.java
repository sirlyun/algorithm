package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                if (pq.size() < N) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
                else {
                    int target = Integer.parseInt(st.nextToken());

                    pq.offer(target);
                    pq.poll();
                }
            }
        }

        System.out.println(pq.poll());
    }
}

