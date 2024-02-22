import java.util.*;

class Solution {
    private static Deque<int[]> stack = new LinkedList<>();
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < answer.length; i++) {
            int target = numbers[i];
            
            // stack이 비어있으면
            if (stack.size() == 0) {
                stack.offer(new int[] {i, target});
            }
            // stack에 뭐가 있으면
            else {
                while (stack.size() > 0 && stack.peekLast()[1] < target) {
                    // 그 값 뽑아내고
                    int[] polled = stack.pollLast();
                    
                    // 값 업데이트
                    answer[polled[0]] = target;
                }
                
                // 값을 넣어준다.
                stack.offer(new int[] {i, target});
            }
        }
        
        return answer;
    }
}
