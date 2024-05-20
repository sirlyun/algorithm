package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static boolean[] a, b, target;
    private static int aCount, bCount;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        a = new boolean[N + 2];
        b = new boolean[N + 2];
        target = new boolean[N + 2];


        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                a[i + 1] = true;
                b[i + 1] = true;
            }
        }

        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                target[i + 1] = true;
            }
        }

        activate(a, 1);
        aCount += 1;

        for (int i = 2; i <= N; i++) {
            // a
            if (a[i - 1] != target[i - 1]) {
                activate(a, i);
                aCount += 1;
            }

            // b
            if (b[i - 1] != target[i - 1]) {
                activate(b, i);
                bCount += 1;
            }
        }

        boolean aOk = true;
        boolean bOk = true;

        // target과 같아졌는지 비교하자
        for (int i = 1; i <= N; i++) {
            if (a[i] != target[i]) {
                aOk = false;
            }
            if (b[i] != target[i]) {
                bOk = false;
            }
        }

        if (!aOk && !bOk) {
            System.out.println(-1);
            return;
        }

        int small = Integer.MAX_VALUE;
        if (aOk) {
            small = Math.min(small, aCount);
        }
        if (bOk) {
            small = Math.min(small, bCount);
        }

        System.out.println(small);
    }

    private static void activate(boolean[] arr, int index) {
        arr[index - 1] = !arr[index - 1];
        arr[index] = !arr[index];
        arr[index + 1] = !arr[index + 1];
    }
}

