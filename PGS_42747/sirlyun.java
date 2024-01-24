/*
    발표한 논문 n편 중, h번 이상 인용된 논문이
    h편 이상이고 나머지 논문은 h번 이하라면
    h의 최댓값이 원하는 값
*/

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int answer = 0;
        
        Arrays.sort(citations);
        
        for (int i=0; i<citations.length; i++){
            int chk = citations.length - i;
            
            if (citations[i] >= chk){
                answer = chk;
                break;
            }
        }
        
        return answer;
    }
}