/*
    자신이 원하는 제품과 수량이
    할인하는 날짜와 10일 연속으로 일치한 경우에
    맞춰서 회원가입
*/

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        int day = 10;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        for (int i=0; i<discount.length - day + 1; i++){
            Map<String, Integer> chkMap = new HashMap<>();
            for (int j=0; j<day; j++){
                chkMap.put(discount[i+j], chkMap.getOrDefault(discount[i+j], 0)+1);
            }
            
            boolean flag = true;
            for (String key : map.keySet()){
                if (map.get(key) != chkMap.get(key)){
                    flag = false;
                    break;
                }
            }
            
            answer += flag ? 1 : 0;
        }
        
        return answer;
    }
}