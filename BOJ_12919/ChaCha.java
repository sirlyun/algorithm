package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        // S를 T로 바꾸는 게임

        // 문자열을 바꿀 때는 다음과 같은 두 가지 연산만 가능

        // 문자열의 뒤에 A를 추가
        // 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.

        // S를 T로 만들 수 있는지 없는지 알아내는 프로그램
        // S를 T로 바꿀 수 있으면 1을 없으면 0을 출력

        // T를 S로 만들어볼까?

        queue.offer(T);

        while (!queue.isEmpty()) {
            String polled = queue.poll();

            if (polled.isEmpty()) {
                continue;
            }

            // S와 같아지면
            if (polled.equals(S)) {
                // 끝
                System.out.println(1);
                return;
            }

            // 맨 뒤가 A면 첫번째 조건 가능
            if (polled.endsWith("A")) {
                queue.offer(polled.substring(0, polled.length() - 1));
            }

            // 맨 앞이 B이면 두번째 조건 가능
            if (polled.startsWith("B")) {
                String removed = polled.substring(1);

                StringBuffer sb = new StringBuffer();
                sb.append(removed);

                queue.offer(sb.reverse().toString());
            }
        }

        System.out.println(0);
    }
}
