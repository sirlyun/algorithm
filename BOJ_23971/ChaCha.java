package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int 세로_몫 = H / (N + 1);
        int 세로_나머지 = H % (N + 1);

        int 세로 = 세로_몫;
        if (세로_나머지 > 0) {
            세로 += 1;
        }

        int 가로_몫 = W / (M + 1);
        int 가로_나머지 = W % (M + 1);

        int 가로 = 가로_몫;
        if (가로_나머지 > 0) {
            가로 += 1;
        }

        answer = 가로 * 세로;

        System.out.println(answer);
    }
}
