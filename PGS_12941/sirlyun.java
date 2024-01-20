/*
    길이가 같은 배열 A, B (자연수로 이루어짐)
    1. 배열에서 각각 한개의 숫자를 뽑기
    2. 두 수 곱하기
    배열의 길이만큼 위 과정을 반복하며, 두 수를 곱한 값을 누적하여 더한다.
    최종적으로 누적된 값이 최소가 되도록 한다.
    
    각 배열에서 가장 작은값과 가장 큰값을 곱해가는 방식?
*/

import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        // A와 B 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int arrLen = A.length;
        
        // 정렬 후 크기가 작은 값과 큰 값이 매칭되서 곱해지도록 진행
        for (int i=0; i<arrLen; i++){
            int calculate = A[i]*B[arrLen-1-i];
            answer += calculate;
        }

        return answer;
    }
}