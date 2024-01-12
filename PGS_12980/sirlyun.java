/*
    슈트 기능
        한번에 K칸을 앞으로 점프하거나 (현재가지 온 거리)x2에 해당하는 위치로 순간이동
        앞으로 K칸 점프는 K만큼의 비용 발생, 순간이동은 비용 없음
    N만큼 떨어져 있는 장소로 이동하고 싶고 비용을 최소화
    -> 짝수에 해당하는 위치로의 이동은 비용이 안든다?
*/

import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int ans = 0;
        
        while (n != 0){
            if ((n % 2) == 0){
                n /= 2;
            } else{
                n -= 1;
                ans += 1;
            }
        }
    
        return ans;
    }
}