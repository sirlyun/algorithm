package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] isDeleted;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        // 입력
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        isDeleted = new boolean[N + 1];
        isDeleted[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!isDeleted[i]) {
                for (int j = i * 2; j <= N; j += i) {
                    isDeleted[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!isDeleted[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
