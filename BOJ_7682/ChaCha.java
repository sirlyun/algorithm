package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    private static char[][] arr = new char[3][3];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();

            if (input.equals("end")) {
                System.out.println(sb);
                return;
            }

            int x = 0;
            int o = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = input.charAt(i * 3 + j);

                    if (arr[i][j] == 'X') {
                        x += 1;
                    }
                    else if (arr[i][j] == 'O') {
                        o += 1;
                    }
                }
            }

            judge(inspect(), x, o);
        }
    }

    private static void judge(int[] result, int x, int o) {
        if (result[0] >= 1 && result[1] == 0 && x == o + 1) {
            sb.append("valid").append("\n");
        }
        else if (result[0] == 0 && result[1] >= 1 && x == o) {
            sb.append("valid").append("\n");
        }
        else if (result[0] == 0 && result[1] == 0 && x == 5 && o == 4) {
            sb.append("valid").append("\n");
        }
        else {
            sb.append("invalid").append("\n");
        }
    }

    private static int[] inspect() {
        int xs = 0;
        int os = 0;

        // 가로
        for (int i = 0; i < 3; i++) {
            int x = 0;
            int o = 0;

            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 'X') {
                    x += 1;
                }
                else if (arr[i][j] == 'O') {
                    o += 1;
                }
            }

            if (x >= 3) {
                xs += 1;
            }
            else if (o >= 3) {
                os += 1;
            }
        }

        // 세로
        for (int i = 0; i < 3; i++) {
            int x = 0;
            int o = 0;

            for (int j = 0; j < 3; j++) {
                if (arr[j][i] == 'X') {
                    x += 1;
                }
                else if (arr[j][i] == 'O') {
                    o += 1;
                }
            }

            if (x >= 3) {
                xs += 1;
            }
            else if (o >= 3) {
                os += 1;
            }
        }

        int x = 0;
        int o = 0;

        // 대각선
        for (int i = 0; i < 3; i++) {
            if (arr[i][i] == 'X') {
                x += 1;
            }
            else if (arr[i][i] == 'O') {
                o += 1;
            }
        }

        if (x >= 3) {
            xs += 1;
        }
        else if (o >= 3) {
            os += 1;
        }

        x = 0;
        o = 0;

        for (int i = 0; i < 3; i++) {
            if (arr[i][2 - i] == 'X') {
                x += 1;
            }
            else if (arr[i][2 - i] == 'O') {
                o += 1;
            }
        }

        if (x >= 3) {
            xs += 1;
        }
        else if (o >= 3) {
            os += 1;
        }

        return new int[] {xs, os};
    }
}

