import java.util.*;

public class Solution {
    private static int count = 0;
    
    public int solution(int n) {
        while (n > 0) {
            int rest = n % 2;
            
            if (rest == 1) {
                count += 1;
            }
            
            n /= 2;
        }
        
        return count;
    }
}
