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
    private static List<List<Integer>> list;
    private static List<List<Integer>> valid;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            list = new ArrayList<>(201);
            valid = new ArrayList<>();

            for (int i = 0; i < 201; i++) {
                list.add(new ArrayList<>(9));
                list.get(i).add(0);
            }

            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            st = new StringTokenizer(input);

            for (int i = 1; i <= N; i++) {
                int team = Integer.parseInt(st.nextToken());

                list.get(team).set(0, list.get(team).get(0) + 1);
            }

            st = new StringTokenizer(input);
            int rank = 1;
            for (int i = 1; i <= N; i++) {
                int team = Integer.parseInt(st.nextToken());

                if (list.get(team).get(0) >= 6) {
                    list.get(team).add(rank++);
                }
            }

            for (int i = 1; i < 201; i++) {
                if (list.get(i).get(0) >= 6) {
                    int sum = 0;

                    for (int j = 1; j <= 4; j++) {
                        sum += list.get(i).get(j);
                    }

                    list.get(i).add(i);
                    list.get(i).add(sum);

                    valid.add(list.get(i));
                }
            }

            valid.sort((o1, o2) -> {
                if (o1.get(8).equals(o2.get(8))) {
                    return o1.get(5) - o2.get(5);
                }

                return o1.get(8) - o2.get(8);
            });

            sb.append(valid.get(0).get(7)).append("\n");
        }

        System.out.println(sb);
    }
}


