import java.util.*;
import java.util.Map.*;

class Solution {
    private static Map<String, Integer> wishList = new HashMap<>();
    private static Set<Entry<String, Integer>> entries;
    
    private static Map<String, Integer> discountList = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // wish list에 넣는다.
        for (int i = 0; i < want.length; i++) {
            wishList.put(want[i], number[i]);
        }
        
        entries = wishList.entrySet();
        
        // 초기화
        for (int i = 0; i < 10; i++) {
            discountList.put(discount[i], discountList.getOrDefault(discount[i], 0) + 1);
        }
        
        // 확인
        for (int i = 0; i <= discount.length - 10; i++) {
            if (check()) {
                answer += 1;
            }
            
            if (i < discount.length - 10) {
            
                discountList.put(discount[i], discountList.getOrDefault(discount[i], 1) - 1);

                discountList.put(discount[i + 10], discountList.getOrDefault(discount[i + 10], 0) + 1);
            }
        }
        
        return answer;
    }
    
    private static boolean check() {
        for (Map.Entry<String, Integer> entry : entries) {
            int targetCount = discountList.getOrDefault(entry.getKey(), 0);
            
            if (targetCount < entry.getValue()) {
                return false;
            }
        }
                
        return true;
    }
}
