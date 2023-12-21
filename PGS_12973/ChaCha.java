import java.util.*;

class Solution {    
    private static Deque<Character> stack = new ArrayDeque<>();
    
    public int solution(String s) {        
        char[] charArray = s.toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
            // stack에 머가 있고, 맨 위에거랑 charArray랑 같으면
            if (!stack.isEmpty() && stack.peek().equals(charArray[i])) {
                // 뽑아버려
                stack.pop();
            }
            // stack이 비어있으면
            else {
                // 채워
                stack.push(charArray[i]);
            }
        }
        
        if (stack.isEmpty()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
