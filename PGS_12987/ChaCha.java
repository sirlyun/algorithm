import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        // 둘 다 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int indexA = 0;
        for (int i = 0; i < B.length; i++) {
            if (A[indexA] < B[i]) {
                indexA ++;
            }
        }
    
        return indexA;
    }
}
