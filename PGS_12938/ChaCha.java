import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int div = s / n;
        
        if (div == 0) {
            return new int[] {-1};
        }
        
        int left = s % n;
        
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = div;
        }
        
        for (int i = answer.length - 1; i >= answer.length - left; i--) {
            answer[i] += 1;
        }
        
        return answer;
    }
}
