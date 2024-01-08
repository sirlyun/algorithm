import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {
    private static Map<Integer, Integer> map = new HashMap<>();
    private static int current = 0;
    private static int answer = 0;
        
    public int solution(int k, int[] tangerine) {
        for (int i = 0 ; i < tangerine.length; i++) {
            int size = tangerine[i];
            
            int count = map.getOrDefault(size, -1);
            
            if (count == -1) {
                map.put(size, 1);
            }
            else {
                map.put(size, count + 1);
            }
        }
        
        List<Entry<Integer, Integer>> collect = map.entrySet()
            .stream()
            .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
            // 리스트로 변환
            .collect(Collectors.toList());

        for (Entry<Integer, Integer> entry : collect) {
            int value = entry.getValue();
            
            answer += 1;
            k -= value;
            
            if (k <= 0) {
                return answer;
            }
        }
        
        return answer;
    }
}
