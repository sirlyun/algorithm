package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    private static List<Character> list = new LinkedList<>();
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] arr = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            list.add(arr[i]);
        }

        int M = Integer.parseInt(br.readLine());

        ListIterator<Character> li = list.listIterator();

        while (li.hasNext()) {
            li.next();
        }

        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("L")) {
                if (li.hasPrevious()) {
                    li.previous();
                }
            }
            else if (command.equals("D")) {
                if (li.hasNext()) {
                    li.next();
                }
            }
            else if (command.equals("B")) {
                if (li.hasPrevious()) {
                    li.previous();
                    li.remove();
                }
            }
            else {
                String target = st.nextToken();
                li.add(target.charAt(0));
            }
        }

        for (Character c : list) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}
