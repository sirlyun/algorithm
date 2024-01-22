package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] inputAlphabets = new int[26];
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            inputAlphabets[chars[i] - 'A'] += 1;
        }

        for (int i = 0; i < N - 1; i++) {
            String newString = br.readLine();

            int diff = input.length() - newString.length();

            if (Math.abs(diff) > 1) {
                continue;
            }

            int[] stringAlphabets = Arrays.copyOf(inputAlphabets, 26);
            char[] newStrings = newString.toCharArray();
            int count = 0;

            for (int j = 0; j < newStrings.length; j++) {
                int temp = newStrings[j] - 'A';

                if (stringAlphabets[temp] > 0) {
                    count += 1;
                    stringAlphabets[temp] -= 1;
                }
            }

            // 단어 하나 제거된 경우
            if (diff == 1) {
                if (input.length() - 1 == count) {
                    answer += 1;
                }
            }
            // 단어 하나 추가된 경우
            else if (diff == -1) {
                if (newString.length() - 1 == count) {
                    answer += 1;
                }
            }
            // 단어가 대체된 경우
            else {
                // 아예 같거나, 한 글자만 대체된 경우
                if (input.length() == count || input.length() - 1 == count) {
                    answer += 1;
                }

            }
        }

        System.out.println(answer);
    }
}
