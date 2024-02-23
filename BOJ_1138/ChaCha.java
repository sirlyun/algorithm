package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static int[] info;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }

        info = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        do {
            // 검증
            if (validate()) {
                for (int i = 0; i < arr.length; i++) {
                    sb.append(arr[i]).append(" ");
                }
                System.out.println(sb);
                return;
            }
        }
        while (nextPermutation());
    }

    private static boolean validate() {
        boolean flag = true;

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];

            int inFrontOf = info[number];

            // 검증
            int result = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > number) {
                    result += 1;
                }
            }

            if (result != inFrontOf) {
                return false;
            }
        }

        return flag;
    }

    private static boolean nextPermutation() {
        // 꼭대기 index
        int topIndex = arr.length - 1;

        // 오른쪽부터 왼쪽으로 탐색하며, 가장 왼쪽 꼭대기를 찾는다.
        while (topIndex >= 1 && arr[topIndex - 1] >= arr[topIndex]) {
            topIndex -= 1;
        }

        // 꼭대기가 없다면, 마지막 순열이다.
        if (topIndex <= 0) {
            return false;
        }

        // 꼭대기를 제외한 나머지 부분 중, 꼭대기 바로 왼쪽 값보다 큰 값 중 가장 작은 값을 찾는다.
        int j = arr.length - 1;
        while (arr[j] <= arr[topIndex - 1]) {
            j -= 1;
        }

        // 찾은 값을 꼭대기 바로 왼쪽 값과 swap 한다.
        swap(topIndex - 1, j);

        // 꼭대기를 제외한 나머지 부분을 오름차순으로 정렬한다.
        j = arr.length - 1;
        while (topIndex < j) {
            swap(topIndex, j);
            topIndex += 1;
            j -= 1;
        }

        return true;
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

