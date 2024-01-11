import java.util.*;

class Solution {
    private static Deque<Character> deque;
    private static int answer;
    
    public int solution(String s) {
        char[] arr = s.toCharArray();
        
        // x칸 회전
        for (int i = 0; i < s.length(); i++) {
            deque = new ArrayDeque<>(s.length());
            
            // 덱에 넣어주고
            for (int j = i; j < i + s.length(); j++) {
                process(arr[j % s.length()]);
            }
            
            // 끝났을 때
            // 비어있으면
            if (deque.size() == 0) {
                // 세준다.
                answer += 1;
            }
        }
        
        return answer;
    }
    
    private static void process(char character) {
        // 비어있으면
        if (deque.size() == 0) {
            // 넣어주고
            deque.offerLast(character);
        }
        // 비어있지 않으면
        else {
            // 맨 뒤를 확인한다.
            char peek = deque.peekLast();
            
            if (peek == '[' && character == ']') {
                // 하나를 꺼낸다.
                deque.pollLast();
            }
            else if (peek == '(' && character == ')') {
                // 하나를 꺼낸다.
                deque.pollLast();
            }
            else if (peek == '{' && character == '}') {
                // 하나를 꺼낸다.
                deque.pollLast();
            }
            // 다르면
            else {
                // 맨 뒤에 넣는다.
                deque.offerLast(character);
            }
                
        }
    }
}
