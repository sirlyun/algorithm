import java.util.*;

class Solution {
    private int answer = Integer.MAX_VALUE;
    
    public int solution(int x, int y, int n) {
        bfs(x, y, n);
        
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        
        return answer;
    }
    
    private void bfs(int x, int y, int n) {
        Deque<int[]> queue = new ArrayDeque<>();
        
        queue.offerLast(new int[] {0, y});
        
        while (!queue.isEmpty()) {
            int[] polled = queue.pollFirst();
            
            int count = polled[0];
            int number = polled[1];
            
            // number가 됐으면
            if (number == x) {
                // 업데이트하고
                answer = Math.min(count, answer);
                
                // 다음 큐
                continue;
            }
            
            int nextCount = count += 1;
            
            // nextCount가 answer보다 작으면 && number가 x보다 크면
            if (nextCount < answer && number > x) {
                // y에서 n을 뺀다.
                int newNumber = number - n;
                
                if (newNumber >= x) {
                    queue.offerLast(new int[] {nextCount, newNumber});
                }
                
                // y에서 2를 나눈다.
                if (number % 2 == 0) {
                    newNumber = number / 2;
                    
                    if (newNumber >= x) {
                        queue.offerLast(new int[] {nextCount, newNumber});
                    }
                }
                
                // y에서 3을 나눈다.
                if (number % 3 == 0) {
                    newNumber = number / 3;
                    
                    if (newNumber >= x) {
                        queue.offerLast(new int[] {nextCount, newNumber});
                    }
                }
            }
        }
    }
}
