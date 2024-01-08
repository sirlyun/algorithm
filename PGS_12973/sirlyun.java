import java.util.*;

class Solution
{
    public int solution(String s)
    {
        
        Stack<String> stack = new Stack<>();
        
        String[] chkString = s.split("");
        
        stack.push(chkString[0]);
        for (int i=1; i<chkString.length; i++){
            if (!stack.isEmpty()){
                if (stack.peek().equals(chkString[i])){
                    stack.pop();
                } else{
                    stack.push(chkString[i]);
                }
            } else{
                stack.push(chkString[i]);
            }
        }
        
        if (stack.isEmpty()){
            return 1;
        } else{
            return 0;
        }
    }
}