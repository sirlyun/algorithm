import java.util.*;
import java.util.stream.*;

class Solution {
    private Map<Integer, Deque<String>> map = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            
            String time = st.nextToken().replace(":", "");
            Integer number = Integer.parseInt(st.nextToken());
            
            // 이미 있으면
            if (map.containsKey(number)) {
                map.get(number).offerLast(time);
            }
            // 없으면
            else {
                Deque<String> newOne = new LinkedList<>();
                newOne.offerLast(time);
                map.put(number, newOne);
            }
        }
        
        // EntrySet을 정렬한다.
        List<Map.Entry<Integer, Deque<String>>> sorted = map.entrySet().stream()
            .sorted(Comparator.comparing(Map.Entry::getKey))
            .collect(Collectors.toList());
        
        // 반복문
        for (Map.Entry<Integer, Deque<String>> entry : sorted) {
            
            Deque<String> stack = entry.getValue();
            
            // 리스트의 개수가 홀수면 
            if (stack.size() % 2 == 1) {
                // 2359를 추가한다.
                stack.offerLast("2359");
            }
            
            int totalTime = 0;
            long totalFee = 0l;
            long danweeFee = 0l;
            while (!stack.isEmpty()) {
                String last = stack.pollLast();
                int convertedLast = convert(last);
                
                String first = stack.pollLast();
                int convertedFirst = convert(first);
                
                totalTime += convertedLast - convertedFirst;
            }
            
            // 누적 주차 시간이 기본 시간 이하라면
            if (totalTime <= fees[0]) {
                answer.add(fees[1]);
            }
            else {
                int overtime = totalTime - fees[0];
                
                int left = overtime % fees[2];
                int mocks = overtime / fees[2];
                
                if (left > 0) {
                    mocks += 1;
                }
                
                answer.add(fees[1] + mocks * fees[3]);
            }
        }
            
        int[] finalAnswer = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            finalAnswer[i] = answer.get(i);
        }
            
        return finalAnswer;
    }
        
    private int convert(String input) {
        int hours = Integer.parseInt(input.substring(0, 2));
        int mins = Integer.parseInt(input.substring(2, 4));
        
        return hours * 60 + mins;
    }
}
