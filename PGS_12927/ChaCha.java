import java.util.*;

class Solution {
    private static Queue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
    
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // queue에 넣어준다.
        for (int i = 0; i < works.length; i++) {
            pq.offer((long) works[i]);
        }
        
        // 시간이 남아있는 동안
        while (!pq.isEmpty() && n > 0) {
            // 최대값 하나를
            long max = pq.poll();
            
            // 시간 하나를 줄이고 다시 넣는다.
            if (max > 1) {
                pq.offer(max - 1);
            }
            
            // 시간 하나를 줄여준다.
            n--;
        }
        
        // 야근 지수를 계산한다.
        while (!pq.isEmpty()) {
            long element = pq.poll();
            answer += Math.pow(element, 2);
        }
        
        return answer;
    }
}
