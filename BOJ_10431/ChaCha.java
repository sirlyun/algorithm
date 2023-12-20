package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer> list = new ArrayList<>();
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int P = Integer.parseInt(br.readLine());

        for (int p = 0; p < P; p++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());

            list.clear();

            int max = 0;
            int count = 0;

            for (int i = 0; i < 20; i++) {
                int target = Integer.parseInt(st.nextToken());

                // max 업데이트
                if (target > max) {
                    max = target;

                    // 가장 큰 사람이니까 뒤에 그냥 넣으면 됨
                    list.add(target);
                }
                else {
                    // 가장 큰 사람이 아니니까, 뒤에서부터 탐색해서 자기보다 작은 사람이 나오면 그 뒤에 넣어주면 됨
                    int howMany = 0;

                    for (int j = list.size() - 1; j >= 0; j--) {
                        if (list.get(j) < target) {
                            list.add(j + 1, target);
                            count += howMany;
                            break;
                        }

                        howMany += 1;

                        // 만약 끝까지 탐색했는데도 자기보다 작은 사람이 없으면, 맨 앞에 넣어주면 됨
                        if (j == 0) {
                            list.add(0, target);
                            count += howMany;
                        }
                    }
                }
            }

            sb.append(T).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }
}


