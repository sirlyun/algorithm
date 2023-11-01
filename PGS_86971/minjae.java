import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        // 전선을 하나씩 끊어보면서 갯수를 세보자
        for(int i = 0; i < n-1; i++) {
            int[][] chk = new int[n-1][2];
            for(int j = 0; j < n-1; j++) {
                if(i != j) {
                    chk[j] = wires[j];
                }
            }
            // 하나 끊고 남은 전선들을 배열에 모아 탐색
            int cnt = bfs(chk, n);
            answer = Math.min(answer, cnt);
        }
        return answer;
    }
    
    static int bfs(int[][] chk, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n-1; i++) {
            graph.get(chk[i][0]).add(chk[i][1]);
            graph.get(chk[i][1]).add(chk[i][0]);
        }
        
        int[] check = new int[n+1];
        int cnt = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        check[1] = 1;
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : graph.get(now)) {
                if(check[next] != 1) {
                    check[next] = 1;
                    cnt++;
                    q.add(next);
                }
            }
        }
        
        return Math.abs(n - cnt*2);
    }
}