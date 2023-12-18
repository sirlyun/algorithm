package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    private static String input;
    private static StringTokenizer st;
    private static List<Integer> list;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        while (!input.startsWith("0")) {
            st = new StringTokenizer(input);
            list = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            // 내림차순 정렬
            Collections.sort(list, Collections.reverseOrder());

            input = br.readLine();

            boolean first = list.get(0).equals(list.get(1));
            boolean second = list.get(1).equals(list.get(2));
            boolean third = list.get(0).equals(list.get(2));

            // invalid
            if (list.get(0) >= list.get(1) + list.get(2)) {
                sb.append("Invalid");
            }
            // Equilateral
            else if (first && second) {
                sb.append("Equilateral");
            }
            else if (first || second || third) {
                sb.append("Isosceles");
            }
            else {
                sb.append("Scalene");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
