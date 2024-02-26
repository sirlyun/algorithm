package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] dp = new int[10001][4];
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // DP
        dp[1][1] = 1; // 1
        dp[2][1] = 1; // 1 + 1
        dp[2][2]= 1; // 2
        dp[3][1] = 1; // 1 + 1 + 1
        dp[3][2] = 1; // 1 + 2
        dp[3][3] = 1; // 3

        int T = Integer.parseInt(br.readLine());

        for(int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1] + dp[n][2] + dp[n][3] + "\n");
        }

        System.out.println(sb);
    }
}
