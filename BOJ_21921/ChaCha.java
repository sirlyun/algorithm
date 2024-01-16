package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int N, X;
    private static List<Integer> list;
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList<>(N);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        for (int i = 0; i < X; i++) {
            count += list.get(i);
        }

        int max = count;
        map.put(max, map.getOrDefault(max,0) + 1);

        for (int i = 1; i <= N - X; i++) {
            count -= list.get(i - 1);
            count += list.get(i + X - 1);

            max = Math.max(max, count);
            map.put(count, map.getOrDefault(count,0) + 1);
        }

        if (max == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(max);
            System.out.println(map.get(max));
        }
    }
}
