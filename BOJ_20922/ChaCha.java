package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] input;
    private static int[] counter = new int[100001];
    private static int N, K;
    private static int count = 0, answer = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        while (l < N && r < N) {
            // 넣을 수 있는지 확인하고
            // 넣을 수 있으면
            if (isAvailable(r)) {
                counter[input[r]] += 1;
                r += 1;
                count += 1;
            }
            // 넣을 수 없으면
            else {
                counter[input[l]] -= 1;
                l += 1;
                count -= 1;
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    private static boolean isAvailable(int r) {
        return counter[input[r]] + 1 <= K;
    }
}
