import java.util.*;

class Solution {
    private Queue<Integer> queue = new LinkedList<>();
    private Deque<Integer> stack = new LinkedList<>();
    private int answer = 0;
    
    public int solution(int[] order) {
        for (int i = 1; i <= order.length; i++) {
            queue.offer(i);
        }
        
        for (int i = 0; i < order.length; i++) {
            int target = order[i];
            
            boolean totalEnd = false;
            
            while (true) {
                // 컨베이어 벨트가 남아있다면
                if (!queue.isEmpty()) {
                    // 컨베이어 벨트를 확인해보자
                    int peeked = queue.peek();

                    // 원하는걸 찾았으면
                    if (peeked == target) {
                        // 꺼내고
                        int polled = queue.poll();

                        // 세자
                        answer += 1;
                        
                        // 찾았으면 다음으로
                        break;
                    }
                }
                
                // 이번엔 보조 컨베이어 벨트를 찾아보자
                if (!stack.isEmpty()) {
                    int peeked = stack.peekLast();

                    // 원하는걸 찾았으면
                    if (peeked == target) {
                        // 꺼내고
                        int polled = stack.pollLast();

                        // 세자
                        answer += 1;

                        // 찾았으면 다음으로
                        break;
                    }
                }

                // 여기까지 왔다면 아직도 못 찾은거니까
                // 컨베이어 벨트가 남아있다면
                if (!queue.isEmpty()) {
                    // 스택에 넣는다.
                    int polled = queue.poll();
                    stack.offerLast(polled);
                } 
                // 컨베이어 벨트가 비었고, stack에도 맞는게 없으면 끝
                else {
                    totalEnd = true;
                    break;
                }
            }
            
            if (totalEnd) {
                break;
            }
        }
        
        return answer;
    }
}
