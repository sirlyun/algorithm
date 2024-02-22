package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private static Deque<Integer> stack1 = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int iter = Integer.parseInt(br.readLine());
        int start = Integer.MAX_VALUE;
        int end = 0;
        int[] arr = new int[1001];
        for (int i = 0; i < iter; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x] = y;
            start = Math.min(x, start);
            end = Math.max(x, end);
        }

        int temp = arr[start];
        for (int i = 0; i <= end; i++) {
            if (arr[i] < temp) {
                stack1.offerLast(i);
            }
            else {
                while (!stack1.isEmpty()) {
                    int x = stack1.pollLast();
                    arr[x] = temp;
                }

                temp = arr[i];
            }
        }

        stack1.clear();

        temp = arr[end];
        for (int i = end - 1; i >= start; i--) {
            if (arr[i] < temp) {
                stack1.offerLast(i);
            }
            else {
                while (!stack1.isEmpty()) {
                    int x = stack1.pollLast();
                    arr[x] = temp;
                }

                temp = arr[i];
            }
        }

        int answer = 0;
        for (int i = start; i <= end; i++) {
            answer += arr[i];
        }

        System.out.println(answer);
    }
}
