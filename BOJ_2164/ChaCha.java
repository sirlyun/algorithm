package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        queue = new ArrayDeque<>(N);

        for (int i = 1; i <= N; i++) {
            queue.offerLast(i);
        }

        while (true) {
            if (queue.size() <= 1) {
                break;
            }
            queue.pollFirst();

            if (queue.size() <= 1) {
                break;
            }
            queue.offerLast(queue.pollFirst());
        }

        System.out.println(queue.pollFirst());
    }
}
