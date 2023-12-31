package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();
    private static char[][] board;
    private static int[] heart, leftArm, rightArm, leftLeg, rightLeg, waist;
    private static int N;
    private static int leftArmLength = 1;
    private static int rightArmLength = 1;
    private static int leftLegLength = 1;
    private static int rightLegLength = 1;
    private static int waistLength = 1;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // N x N 정사각형
        board = new char[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            String input = br.readLine();
            for (int c = 1; c <= N; c++) {
                board[r][c] = input.charAt(c - 1);
            }
        }

        // 1, 1부터 머리를 찾자.
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (board[r][c] == '*') {
                    // 머리 찾음
                    // 그 바로 아래의 심장의 위치를 기록
                    heart = new int[]{r + 1, c};

                    break;
                }
            }

            if (heart != null && heart.length == 2) {
                break;
            }
        }


        // 왼팔 탐색하며 길이 기록
        leftArm = new int[]{heart[0], heart[1] - 1};
        while (true) {
            int next = leftArm[1] - 1;

            // 보드 밖은 위험해
            if (next < 1) {
                break;
            }

            // 끝이야?
            if (board[heart[0]][next] != '*') {
                break;
            }

            leftArmLength += 1;

            leftArm[1] = next;
        }

        // 오른팔 탐색하며 길이 기록
        rightArm = new int[]{heart[0], heart[1] + 1};
        while (true) {
            int next = rightArm[1] + 1;

            // 보드 밖은 위험해
            if (next > N) {
                break;
            }

            // 끝이야?
            if (board[heart[0]][next] != '*') {
                break;
            }

            rightArmLength += 1;

            rightArm[1] = next;
        }

        // 허리 탐색하며 길이 기록
        waist = new int[]{heart[0] + 1, heart[1]};
        while (true) {
            int next = waist[0] + 1;

            // 보드 밖은 위험해
            if (next > N) {
                break;
            }

            // 끝이야?
            if (board[next][heart[1]] != '*') {
                // 다리 기록하고 끝내
                leftLeg = new int[] {next, heart[1] - 1};
                rightLeg = new int[] {next, heart[1] + 1};
                break;
            }

            waistLength += 1;

            waist[0] = next;
        }

        // 왼쪽 다리 탐색하며 길이 기록
        while (true) {
            int next = leftLeg[0] + 1;

            // 보드 밖은 위험해
            if (next > N) {
                break;
            }

            // 끝이야?
            if (board[next][leftLeg[1]] != '*') {
                break;
            }

            leftLegLength += 1;

            leftLeg[0] = next;
        }


        // 오른쪽 다리 탐색하며 길이 기록
        while (true) {
            int next = rightLeg[0] + 1;

            // 보드 밖은 위험해
            if (next > N) {
                break;
            }

            // 끝이야?
            if (board[next][rightLeg[1]] != '*') {
                break;
            }

            rightLegLength += 1;

            rightLeg[0] = next;
        }

        // 출력
        sb.append(heart[0]).append(" ").append(heart[1]).append("\n");

        // 심장의 위치
        // 팔, 허리, 다리의 길이
        sb.append(leftArmLength).append(" ").append(rightArmLength).append(" ").append(waistLength).append(" ").append(leftLegLength).append(" ").append(rightLegLength);

        System.out.println(sb);
    }
}


