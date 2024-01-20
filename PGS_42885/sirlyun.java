/*
    구명보트에는 한 번에 2명씩 탈 수 있고, 무게 제한이 있다
    구명보트를 최대한 적게 사용하여 모든 사람 구출
*/

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        while (start <= end){
            if (people[start]+people[end] <= limit){
                start++;
                end--;
            } else{
                end--;
            }
            answer++;
        }
        
        return answer;
    }
}