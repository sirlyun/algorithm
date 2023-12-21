import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            
            if (now == '('){
                stack.push(now);
            } else{
                if (!stack.isEmpty()){
                    if (stack.peek() == '('){
                        stack.pop();   
                    } else{
                        stack.push(now);
                    }
                } else{
                    stack.push(now);
                }
            }
        }

        return stack.isEmpty();
    }
}