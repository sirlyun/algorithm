package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    private static List<Integer> numbers = new ArrayList<>();
    private static List<String> names = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int limit = Integer.parseInt(st.nextToken());

            numbers.add(limit);
            names.add(name);
        }

        for (int m = 0; m < M; m++) {
            int input = Integer.parseInt(br.readLine());

            int result = binarySearch(input);

            sb.append(names.get(result)).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int target) {
        int l = 0;
        int r = numbers.size();

        while (l < r) {
            int mid = (l + r) / 2;

            int num = numbers.get(mid);

            if (num >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return l;
    }
}
