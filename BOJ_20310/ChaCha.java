package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);

            if (target == '0') {
                zeros += 1;
            }
            else {
                ones += 1;
            }
        }

        zeros /= 2;
        ones /= 2;

        // 제거
        boolean[] deleted = new boolean[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if (ones < 1) {
                break;
            }

            char target = input.charAt(i);
            if (target == '1' && !deleted[i]) {
                deleted[i] = true;

                ones -= 1;
            }
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            if (zeros < 1) {
                break;
            }

            char target = input.charAt(i);
            if (target == '0' && !deleted[i]) {
                deleted[i] = true;

                zeros -= 1;
            }
        }

        String answer = "";
        for (int i = 0; i < deleted.length; i++) {
            if (!deleted[i]) {
                answer += input.charAt(i);
            }
        }

        System.out.println(answer);
    }
}
