package algo_java.src;

/*
    길이가 같은 두개의 큐가 주어진다.
    하나의 큐를 골라 원소를 추출하고, 추출된 원소를 다른 큐에 집어 넣는 작업을 통해 각 큐의 원소 합이 같도록 만든다.
    필요한 작업의 최소 횟수를 구한다.
    한 번의 pop과 한 번의 insert를 합쳐 작업 1회로 간주한다.
*/

import java.util.*;
class Solution {
    static long total(int[] q) {
        long sum = 0;
        for(int i = 0; i < q.length; i++) {
            sum += (long) q[i];
        }

        return sum;
    }
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = total(queue1);
        long sum2 = total(queue2);

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        while(sum1 != sum2) {
            if(answer > (queue1.length + queue2.length) * 2){
                return -1;
            }

            int tmp = 0;

            if(sum1 < sum2) {
                tmp = q2.poll();
                q1.add(tmp);
                sum1 += (long) tmp;
                sum2 -= (long) tmp;
            }
            else if(sum1 > sum2) {
                tmp = q1.poll();
                q2.add(tmp);
                sum1 -= (long) tmp;
                sum2 += (long) tmp;
            }
            else {
                return answer;
            }
            answer++;
        }
        return answer;
    }
}