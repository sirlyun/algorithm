/*
    begin 단어에서 target 단어로 변환하는 가장 짧은 과정을 찾는다
    규칙
        1. 한 번에 한 개의 알파벳만 바꿀 수 있다
        2. words에 있는 단어로만 변환할 수 있다
*/

class Solution {

    static Boolean[] visited;
    static int answer;

    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;

        visited = new Boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            visited[i] = false;
        }

        dfs(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public static void dfs(String begin, String target, String[] words, int depth) {

        if (begin.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        } else {
            if (depth == words.length) {
                return;
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                String[] origin = begin.split("");
                String[] check = words[i].split("");
                int count = 0;
                for (int j = 0; j < begin.length(); j++) {
                    if (!origin[j].equals(check[j])) {
                        count++;
                    }
                }

                if (count == 1) {
                    visited[i] = true;
                    dfs(words[i], target, words, depth + 1);
                    visited[i] = false;
                }
            }
        }
        return;
    }
}