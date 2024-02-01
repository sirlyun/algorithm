/*
    야근 피로도는 야근을 시작한 시점에서
    남은 일의 작업량을 제곱하여 더한 값이다.
    N시간 동안 야근 피로도를 최소화하도록 일한다.
    1시간동안 작업량 1만큼 처리한다 할 때
    남은 N시간과 각 일에 대한 작업량 work에 대해 피로도 최소화한 값을 반환해라
*/

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        long answer = 0;
        
        PriorityQueue<Integer> workQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works){
            workQueue.add(work);
        }
        
        while (n>0){
            int work = workQueue.poll();
            if (work == 0){
                break;
            }
            
            work -= 1;
            workQueue.add(work);
            n -= 1;
        }
        
        for (Integer work : workQueue){
            answer += work * work;
        }
        
        return answer;
    }
}