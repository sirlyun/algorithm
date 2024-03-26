package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static int[] arr;
    private static int N;
    private static int[] pair = new int[2];
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 입력
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        binarySearch();

        System.out.println(pair[0] + " " + pair[1]);
    }

    private static void binarySearch() {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            int result = arr[l] + arr[r];

            int abs = Math.abs(result);
            if (abs < min) {
                min = abs;
                pair[0] = arr[l];
                pair[1] = arr[r];
            }

            if (result == 0) {
                // 끝
                break;
            }
            else if (result > 0) {
                r --;
            }
            else {
                l ++;
            }
        }

    }
}
