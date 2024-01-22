/*
    수확한 귤 중 k개를 골라 상자 하나에 담기
    귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화
*/

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(((o1, o2) -> map.get(o2) - map.get(o1)));

        for (Integer i : keyList) {
            if (k <= 0) {
                break;
            }

            answer++;
            k -= map.get(i);
        }

        return answer;
    }
}