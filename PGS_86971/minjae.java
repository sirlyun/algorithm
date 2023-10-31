import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        HashSet<Integer> setA = new HashSet<Integer>();
        HashSet<Integer> setB = new HashSet<Integer>();
        
        // 전선을 하나씩 끊어보면서 갯수를 세보자
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-1; j++) {
                if(i != j) {
                    if(setA.size() == 0) {
                        // setA가 비어있는지
                        setA.add(wires[j][0]);
                        setA.add(wires[j][1]);
                    }
                    else if(setA.contains(wires[j][0]) || setA.contains(wires[j][1])) {
                        // 다음 노드 2개 중 하나라도 setA 안에 있을 경우
                        setA.add(wires[j][0]);
                        setA.add(wires[j][1]);
                    }
                    else {
                        // setA에 값이 있으면서 다음 노드들이 setA에 소속되지 않을 경우
                        setB.add(wires[j][0]);
                        setB.add(wires[j][1]);
                    }
                }
            }
            // 한 바퀴 돌고나면 갯수 파악 + set 초기화
            if(answer > Math.abs(setA.size() - setB.size())) {
                answer = Math.abs(setA.size() - setB.size());
            }
            setA.clear();
            setB.clear();
        }
        return answer;
    }
}