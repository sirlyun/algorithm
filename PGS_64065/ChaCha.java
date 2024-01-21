import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private static Map<Integer, Integer> map = new HashMap<>();
    
    public int[] solution(String s) {
        char[] input = s.toCharArray();
        
        char[] elements = new char[input.length - 2];
        
        System.arraycopy(input, 1, elements, 0, input.length - 2);
        
        for (int i = 0; i < elements.length; i++) {
            // element의 시작
            if (elements[i] == '{') {
                char[] inside = new char[1];
                
                // }를 찾아보자.
                for (int j = i + 1; j < elements.length; j++) {
                    if (elements[j] == '}') {
                        inside = new char[j - i - 1];
                        System.arraycopy(elements, i + 1, inside, 0, j - i - 1);
                        i = j;
                        break;
                    }
                }
                
                // 요소 하나 꺼냈으면
                String insideString = String.valueOf(inside);
                String[] splitted = insideString.split(",");
                
                for (String ele : splitted) {
                    int number = Integer.parseInt(ele);
                    
                    map.put(number, map.getOrDefault(number, 0) + 1);
                }
            }
            else if (elements[i] == ',') {
                continue;
            }
        }
        
        List<Map.Entry<Integer, Integer>> list = 
            map.entrySet().stream()
            .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
            .collect(Collectors.toList());
            
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getKey();
        }
        
        return answer;
    }
}
