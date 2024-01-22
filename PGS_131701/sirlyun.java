import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
 
        int chk = 1;
        while (chk <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int total = 0;
                for (int j = i; j < i + chk; j++) {
                    total += elements[j % elements.length];
                }
                set.add(total);
            }
            chk++;
        }
 
        return set.size();
    }
}