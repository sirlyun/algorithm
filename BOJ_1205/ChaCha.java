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
    private static StringTokenizer st;
    private static List<Integer> list = new ArrayList<>();
    private static int rank = 1;
    private static int count = 1;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.add(newScore);

        list.sort(Comparator.reverseOrder());

        int result = lowerBound(newScore);

        if (result > P) {
            System.out.println(-1);
            return;
        }
        else {
            int next = result - 1;
            while (next >= 0) {
                if (list.get(next) == newScore) {
                    next -= 1;
                }
                else {
                    System.out.println(next + 2);
                    return;
                }
            }

            // 맨 앞인 경우
            System.out.println(1);
            return;
        }
    }

    private static int lowerBound(int target) {
        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = (l + r) / 2;

            if (list.get(mid) < target) {
                r = mid;
            }
            else if (list.get(mid) >= target) {
                l = mid + 1;
            }
        }

        // 넣어야 할 위치를 return
        return l;
    }
}


