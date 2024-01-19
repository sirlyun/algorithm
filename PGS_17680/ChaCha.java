import java.util.*;

class Solution {
    private static int answer = 0;
    private static List<String> list;
    
    public int solution(int cacheSize, String[] cities) {  
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        list = new ArrayList<>(cacheSize);
        
        for (int i = 0; i < cities.length; i++) {
            String input = cities[i].toLowerCase();
            
            if (list.remove(input)) {
                answer += 1;
                list.add(input);
            }
            else {
                answer += 5;
                
                if (list.size() >= cacheSize) {
                    if (list.size() >= 1) {
                        list.remove(0);
                    }
                }
                
                list.add(input);
            }
        }
        
        return answer;
    }
}
