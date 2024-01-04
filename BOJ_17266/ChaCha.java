package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static int[] lights;
    private static int result;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lights = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            lights[m] = Integer.parseInt(st.nextToken());
        }

        result = 0;

        int l = 1;
        int r = N;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (compute(mid)) {
                result = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean compute(int height) {
        int prev = 0;

        for (int i = 0; i < M; i++) {
            if (lights[i] - height <= prev) {
                prev = lights[i] + height;
            }
            else {
                return false;
            }
        }

        return N - prev <= 0;
    }
}
