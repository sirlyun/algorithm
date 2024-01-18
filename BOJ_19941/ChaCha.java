package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K, p, h, answer;
    private static boolean[] taken;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 거리가 K 이하인 햄버거 먹을 수 있음

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String input = br.readLine();

        p = 0;
        h = 0;
        answer = 0;
        taken = new boolean[input.length()];

        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == 'P') {
                int target = Math.max(i - K, 0);

                for (int j = target; j <= Math.min(i + K, input.length() - 1); j++) {
                    if (input.charAt(j) == 'H' && !taken[j]) {
                        taken[j] = true;
                        answer += 1;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
