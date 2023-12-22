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

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        // 입력
        int N = Integer.parseInt(st.nextToken());

        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[3];

            for (int i = 0; i < 2; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            arr[2] = 1;

            list.add(arr);
        }

        // 등 수 결정
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }

                if ((list.get(j)[0] > list.get(i)[0] && list.get(j)[1] > list.get(i)[1])) {
                    list.get(i)[2] += 1;
                }
            }
        }

        for (int n = 0; n < list.size(); n++) {
            sb.append(list.get(n)[2]).append(" ");
        }

        System.out.println(sb);
    }
}


