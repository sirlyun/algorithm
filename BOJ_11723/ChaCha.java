package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    private static boolean[] arr = new boolean[21];
    private static StringTokenizer st;

    enum Calculator {
        // S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
        ADD("add", (number) -> {
            if (arr[number]) {
                return 0;
            }

            arr[number] = true;
            return 1;
        }),
        // S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
        REMOVE("remove", (number) -> {
            if (!arr[number]) {
                return 0;
            }

            arr[number] = false;
            return 1;
        }),

        // S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
        CHECK("check", (number) -> {
            if (arr[number]) {
                return 1;
            } else {
                return 0;
            }
        }),

        // S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
        TOGGLE("toggle", (number) -> {
            arr[number] = !arr[number];
            return 1;
        }),

        // S를 {1, 2, ..., 20} 으로 바꾼다.
        ALL("all", (number) -> {
            Arrays.fill(arr, true);
            return 1;
        }),

        // S를 공집합으로 바꾼다.
        EMPTY("empty", (number) -> {
            Arrays.fill(arr, false);
            return 1;
        });

        private final String symbol;
        private final Function<Integer, Integer> expression;

        Calculator(final String symbol, final Function<Integer, Integer> expression) {
            this.symbol = symbol;
            this.expression = expression;
        }

        public int calculate(final int number) {
            return expression.apply(number);
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            int number = 0;

            if (command.equals("all") || command.equals("empty")) {
                number = 0;
            } else {
                number = Integer.parseInt(st.nextToken());
            }

            int result = Calculator.valueOf(command.toUpperCase()).calculate(number);

            if (command.equals("check")) {
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }
}


