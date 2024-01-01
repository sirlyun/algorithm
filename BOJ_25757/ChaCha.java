package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();
    private static Set<String> set = new HashSet<>();
    private static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }

        int count = set.size();

        if (game.equals("Y")) {
            System.out.println(count);
        }
        else if (game.equals("F")) {
            System.out.println(count / 2);
        }
        else if (game.equals("O")) {
            System.out.println(count / 3);
        }
    }
}


