package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static long answer = 0;
    private static int[] lengthOfRoads;
    private static int[] priceOfGas;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        lengthOfRoads = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            lengthOfRoads[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        priceOfGas = new int[N];
        for (int i = 0; i < N; i++) {
            priceOfGas[i] = Integer.parseInt(st.nextToken());
        }

        findMinimumInRange(N - 2);

        System.out.println(answer);
    }

    private static void findMinimumInRange(int end) {
        long length = 0;
        long validLength = 0;
        long minPrice = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = end; i >= 0; i--) {
            int currentPrice = priceOfGas[i];
            length += lengthOfRoads[i];

            if (currentPrice <= minPrice) {
                minPrice = currentPrice;
                validLength = length;
                minIndex = i;
            }
        }

        answer += minPrice * validLength;

        if (minIndex > 0) {
            findMinimumInRange(minIndex - 1);
        }
    }
}
