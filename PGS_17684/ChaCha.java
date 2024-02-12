import java.util.*;

class Solution {
    private static Map<String, Integer> map = new HashMap<>();
    private static StringBuffer sb = new StringBuffer();
    private static int index = 27;
    private static List<Integer> answer = new ArrayList<>();
    
    public int[] solution(String msg) {
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i + 1);
        }
        
        for (int i = 0; i < msg.length(); i++) {
            int currentPrint = 0;
            String lastTarget = "";
            
            for (int j = 1; j <= msg.length() - i; j++) {
                String target = msg.substring(i, i + j);
                
                int result = map.getOrDefault(target, -1);
                
                // 사전에 있으면
                if (result > 0) {
                    // 출력에 기록
                    currentPrint = result;
                    lastTarget = target;
                    
                    // 더 긴 길이 확인
                }
                // 사전에 없으면
                else {
                    map.put(target, index++);
                    
                    // 탐색 끝
                    break;
                }                
            }
            
            i += lastTarget.length() - 1;
            
            // 출력
            answer.add(currentPrint);
        }
        
        int[] finalAnswer = new int[answer.size()];
        
        for (int i = 0; i < answer.size(); i++) {
            finalAnswer[i] = answer.get(i);
        }
        
        return finalAnswer;
    }
}
