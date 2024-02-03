import java.util.*;

class Solution {
    private static PriorityQueue<Integer> asc = new PriorityQueue<>();
    private static PriorityQueue<Integer> desc = new PriorityQueue<>(Comparator.reverseOrder());
    
    public int[] solution(String[] operations) {        
        for (String operation : operations) {
            process(operation);
        }
        
        // 모든 연산을 처리한 후 
        // 큐가 비어있으면 [0,0] 
        if (asc.isEmpty()) {
            return new int[] {0, 0};
        }
        
        // 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
        if (asc.size() == 1) {
            int answer = asc.peek();
            return new int[] {answer, answer};
        }
        
        return new int[] {desc.poll(), asc.poll()};
    }
    
    private static boolean process(String input) {
        // 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
        StringTokenizer st = new StringTokenizer(input);
            
        String first = st.nextToken();
        int second = Integer.parseInt(st.nextToken());
        
        if (first.equals("I")) {
            asc.offer(second);
            desc.offer(second);
            
            return true;
        }
        else {
            // 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
            if (asc.isEmpty()) {
                return false;
            }
            
            // 최소값 제거
            if (second == -1) {
                int min = asc.poll();
                desc.remove(min);
            }
            else {
                int max = desc.poll();
                asc.remove(max);
            }
            
            return true;
        }
    }
}
