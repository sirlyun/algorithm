package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();
    private static List<Character> list = List.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            boolean result = false;

            st = new StringTokenizer(br.readLine());

            String text = st.nextToken();

            if (text.equals("end")) {
                break;
            }

            char[] chars = text.toCharArray();

            // 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                    result = true;
                    break;
                }
            }

            // 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
            if (result) {
                if (chars.length >= 2) {
                    for (int i = 0; i <= chars.length - 2; i++) {
                        if (chars[i] == chars[i + 1]) {
                            if (chars[i] == 'e' || chars[i] == 'o') {
                                result = true;
                                break;
                            }
                            else {
                                result = false;
                                break;
                            }
                        }
                    }
                }
            }

            // 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
            if (result) {
                if (chars.length >= 3) {
                    for (int i = 0; i <= chars.length - 3; i++) {
                        if (list.contains(chars[i]) == list.contains(chars[i + 1]) && list.contains(chars[i + 1]) == list.contains(chars[i + 2])) {
                            result = false;
                            break;
                        }
                    }
                }
            }

            if (result) {
                sb.append("<").append(text).append("> is acceptable.\n");
            }
            else {
                sb.append("<").append(text).append("> is not acceptable.\n");
            }
        }

        System.out.println(sb);
    }
}


