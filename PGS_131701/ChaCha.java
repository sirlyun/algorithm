import java.util.*;

class Solution {
    private static Set<Integer> set = new HashSet<>();
    public int solution(int[] elements) {          
        // 시작점
        for (int i = 0; i < elements.length; i++) {
            int answer = 0;

            for (int j = i; j < i + elements.length; j++) {
                answer += elements[j % elements.length];
                
                set.add(answer);
            }
        }
        
        return set.size();
    }
}
