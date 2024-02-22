/*
    2*N명의 사원들은 N명씩 두 팀으로 나눠 게임을 한다.
    규칙
        - 모든 사원이 무작위로 자연수를 부여 받는다.
        - 각 사원은 한 번만 경기를 한다.
        - 경기 당 A팀에서 한명, B팀에서 한명이 숫자를 공개한다.
        - 숫자가 큰 쪽이 승리하고, 그 사람이 속한 팀은 승점 1점을 얻는다.
        - 숫자가 같으면 승점이 주어지지 않는다.
    A팀의 숫자 구성과 출전 순서를 보고 B팀의 승점이 최대가 되도록 순서를 정하자
*/

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int j = B.length-1;
        for (int i = A.length-1; i >= 0; i--) {
            if (A[i] < B[j]) {
                answer++;
                j--;
            }
        }
        
        return answer;
    }
}