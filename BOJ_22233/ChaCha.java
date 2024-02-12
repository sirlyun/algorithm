package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static Map<String, Boolean> map;
    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>(N);

        for (int n = 0; n < N; n++) {
            map.put(br.readLine(), true);
        }

        long left = map.size();

        for (int m = 0; m < M; m++) {
            String input = br.readLine();
            String[] splitted = input.split(",");

            for (int i = 0; i < splitted.length; i++) {
                if (map.getOrDefault(splitted[i], false)) {
                    map.put(splitted[i], false);
                    left -= 1;
                }
            }

            sb.append(left).append("\n");
        }

        System.out.println(sb);
    }
}
