package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int H, W;
    private static int[] arr;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        // 입력
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int l = 1; l < W - 1; l++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int i = 0; i < l; i++) {
                leftMax = Math.max(leftMax, arr[i]);
            }

            for (int i = W - 1; i > l; i--) {
                rightMax = Math.max(rightMax, arr[i]);
            }

            int height = Math.min(leftMax, rightMax) - arr[l];

            if (height > 0) {
                answer += height;
            }
        }

        System.out.println(answer);
    }
}
