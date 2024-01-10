package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static StringTokenizer st;
    private static int N, M;
    private static Map<String, Integer> map;
    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>(N);

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.length() >= M) {
                map.put(input, map.getOrDefault(input, 0) + 1);
            }
        }

        // 자주 나오는 순 정렬
        List<Entry<String, Integer>> collect = map.entrySet().stream()
            .sorted((o1, o2) -> {
                if (!o1.getValue().equals(o2.getValue())) {
                    return o2.getValue().compareTo(o1.getValue());
                }

                if (!(o1.getKey().length() == o2.getKey().length())) {
                    return o2.getKey().length() - o1.getKey().length();
                }

                return o1.getKey().compareTo(o2.getKey());
            })
            .collect(Collectors.toList());

        for (Entry<String, Integer> entry : collect) {
            sb.append(entry.getKey()).append("\n");
        }

        System.out.println(sb);
    }
}
