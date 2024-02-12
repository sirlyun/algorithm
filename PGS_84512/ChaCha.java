import java.util.*;

class Solution {
    private static List<Character> chars = Arrays.asList('A', 'E', 'I', 'O', 'U');
    private static int[] counts = new int[] {781, 156, 31, 6, 1};
    
    public int solution(String word) {
        int answer = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int index = chars.indexOf(word.charAt(i));
            
            answer += index * counts[i] + 1;
        }
        
        return answer;
    }
}
