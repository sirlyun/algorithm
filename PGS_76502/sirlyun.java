/*
    괄호로 이루어진 문자열
    문자열 왼쪽으로 x칸만큼 회전
    올바른 괄호 문자열이 되게 하는 x의 개수는?
*/

import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = 0;
        
        Queue<String> queue = new LinkedList<>();
        for (String i : s.split("")){
            queue.add(i);
        }
        
        for (int i=0; i<s.length(); i++){
            queue.add(queue.poll());
            Stack<String> stack = new Stack<>();
            for (int j=0; j<s.length(); j++){
                String chk = queue.poll();
                queue.add(chk);
                
                if(stack.isEmpty()){
                    stack.push(chk);
                } 
                else if(chk.equals(")") && stack.peek().equals("(")){
                    stack.pop();
                }
                else if(chk.equals("]") && stack.peek().equals("[")){
                    stack.pop();
                }
                else if(chk.equals("}") && stack.peek().equals("{")){
                    stack.pop();
                }
                else{
                    stack.push(chk);
                }
            }
            
            if (stack.isEmpty()){
                answer++;
            }
        }
        
        return answer;
    }
}