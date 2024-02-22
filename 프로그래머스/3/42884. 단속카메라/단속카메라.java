import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int left = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (route[0] > left) {
                left = route[1];
                answer++;
            }
        }
            
        return answer;
    }
}