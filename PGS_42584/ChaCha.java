import java.util.*;

class Solution {
    private Deque<int[]> stack = new LinkedList<>();
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {            
            // 비어있으면
            if (stack.isEmpty()) {
                stack.offerLast(new int[] {i, prices[i]});
            }
            // stack에 있으면
            else {
                int[] peeked = stack.peekLast();
                
                if (peeked[1] <= prices[i]) {
                    stack.offerLast(new int[] {i, prices[i]});
                }
                else {
                    while (!stack.isEmpty() && stack.peekLast()[1] > prices[i]) {
                        int[] polled = stack.pollLast();
                        
                        answer[polled[0]] = i - polled[0];
                    }
                    
                    stack.offerLast(new int[] {i, prices[i]});
                }
            }
        }
        
        while (!stack.isEmpty()) {
            int[] polled = stack.pollLast();
            
            answer[polled[0]] = prices.length - polled[0] - 1;
        }
        
        return answer;
    }
}
