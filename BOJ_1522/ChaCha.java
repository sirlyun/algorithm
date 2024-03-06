package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static char[] arr;
    private static String input;
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        arr = input.toCharArray();

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (arr[i] == 'a') {
                count += 1;
            }
        }

        for (int i = 0; i < input.length(); i++) {
            int anotherCount = 0;
            for (int j = i; j < i + count; j++) {
                if (arr[j % input.length()] == 'b') {
                    anotherCount += 1;
                }
            }

            answer = Math.min(anotherCount, answer);
        }

        System.out.println(answer);
    }
}
