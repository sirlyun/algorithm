import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> {
            return a[1] - b[1];
        });
        
        answer += 1;
        int max = routes[0][1];
        for (int[] route : routes) {
            if (max < route[0]) {
                answer += 1;
                max = route[1];
            }
        }
        
        return answer;
    }
}
