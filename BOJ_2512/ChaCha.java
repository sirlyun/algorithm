package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static List<Integer> list;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());

        list.sort(Comparator.comparingInt(o -> o));

        System.out.println(binarySearch(0, list.get(list.size() - 1)));
    }

    private static int binarySearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return right;
    }

    private static boolean check(int limit) {
        int result = 0;

        for (Integer i : list) {
            result += Math.min(i, limit);

            if (result > M) {
                return false;
            }
        }

        return true;
    }
}
