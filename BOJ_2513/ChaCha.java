package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, d, k, c, answer;
    private static List<Integer> list;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        list = new ArrayList<>(N);

        for (int n = 0; n < N; n++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        for (int n = 0; n < N; n++) {
            int[] arr = new int[d + 1];
            arr[c] += 1;

            for (int i = 0; i < k; i++) {
                int index = (n + i) % N;

                arr[list.get(index)] += 1;
            }

            int count = 0;
            for (int i = 0; i < d + 1; i++) {
                if (arr[i] > 0) {
                    count += 1;
                }
            }

            answer = Math.max(count, answer);
        }

        System.out.println(answer);
    }
}
