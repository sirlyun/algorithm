package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Member {
        private int level;
        private String name;

        public Member(int level, String name) {
            this.level = level;
            this.name = name;
        }

        public int getLevel() {
            return this.level;
        }

        public String getName() {
            return this.name;
        }
    }

    public static class Bang {
        private int levelLimit;
        private List<Member> members = new ArrayList<>(M);

        public Bang(Member member) {
            this.levelLimit = member.getLevel();
            this.members.add(member);
        }

        public int getLevelLimit() {
            return this.levelLimit;
        }

        public int getHowMany() {
            return this.members.size();
        }

        public List<Member> getMembers() {
            return this.members;
        }

        public void addMember(Member member) {
            this.members.add(member);
        }
    }
    private static int P, M;
    private static List<Bang> bangs = new ArrayList<>();
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int p = 0; p < P; p++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            // 방이 없으면
            if (bangs.isEmpty()) {
                // 방을 생성한다.
                bangs.add(new Bang(new Member(i, n)));
            }
            // 방이 있으면
            else {
                boolean didYouFindIt = false;

                // 적절한 방을 찾는다.
                for (Bang b : bangs) {
                    // 레벨 범위 안에 들어가고, 자리가 있으면
                    if (Math.abs(b.getLevelLimit() - i) <= 10 && b.getHowMany() < M) {
                        b.addMember(new Member(i, n));

                        // 다음 사람!
                        didYouFindIt = true;
                        break;
                    }
                }

                // 적절한 방이 없으면
                if (!didYouFindIt) {
                    bangs.add(new Bang(new Member(i, n)));
                }
            }
        }

        for (Bang b : bangs) {
            // 방이 가득 찼으면
            if (b.getMembers().size() == M) {
                // Started! 출력
                sb.append("Started!").append("\n");
            }
            // 방이 가득차지 않았으면
            else {
                sb.append("Waiting!").append("\n");
            }

            // 이름 순 정렬
            b.getMembers().sort(Comparator.comparing(Member::getName));

            // 이름 출력
            b.getMembers().forEach((member) -> sb.append(member.getLevel()).append(" ").append(member.getName()).append("\n"));
        }

        System.out.println(sb);
    }
}
