package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    private static int answer = 1;
    private static int max = 1;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N > max) {
            max += (answer) * 6;

            answer += 1;
        }

        System.out.println(answer);
    }
}
