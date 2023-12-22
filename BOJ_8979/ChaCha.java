package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();
    private static List<int[]> list = new ArrayList<>();
    private static int[] 등수;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        // 입력
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        등수 = new int[N + 1];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[4];

            for (int i = 0; i < 4; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            list.add(arr);
        }

        // 정렬
        list.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[2] == o2[2]) {
                    return Integer.compare(o2[3], o1[3]);
                } else {
                    return Integer.compare(o2[2], o1[2]);
                }
            }

            return Integer.compare(o2[1], o1[1]);
        });

        int place = 2;

        // 등 수 결정
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                등수[list.get(0)[0]] = 1;
                continue;
            }

            // 전 팀과 등수가 같은 경우
            if (list.get(i - 1)[1] == list.get(i)[1] && list.get(i - 1)[2] == list.get(i)[2] && list.get(i - 1)[3] == list.get(i)[3]) {
                // 전 사람과 같은 등수를 기록한다.
                등수[list.get(i)[0]] = 등수[list.get(i - 1)[0]];
            }
            // 등수가 다른 경우
            else {
                등수[list.get(i)[0]] = place;
            }

            place += 1;
        }

        System.out.println(등수[K]);
    }
}


