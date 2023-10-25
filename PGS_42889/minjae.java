import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // 해쉬 맵
        HashMap<Integer, Double> map = new HashMap(N);
        
        // 실패율 배열
        Double[] fail_arr = new Double[N];
        
        // 스테이지 도전자 수, 실패 수
        int challenger = 0;
        int fail_cnt = 0;
        
        for (int i = 1; i <= N; i++) {
            // 1번부터 N번 스테이지까지
            challenger = 0;
            fail_cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                // 도전자들이 어떤 스테이지 도전 중인지
                if (stages[j] >= i) {
                    challenger++;
                }
                if (stages[j] == i) {
                    fail_cnt++;
                }
            }
            // 스테이별 실패율을 계산해서 배열에 삽입
            double failure = (double)fail_cnt / challenger;
            map.put(i, failure);
            fail_arr[i-1] = failure;
        }
        
        // 실패율 내림차순
        Arrays.sort(fail_arr, Collections.reverseOrder());
        
        // 1부터 N번까지의 키로 실패율을 찾고 실패율 배열을 순회하며 answer에 인덱스 삽입하기
        for (int i = 1; i <= N; i++) {
            double temp = map.get(i);
            for (int j = 0; j < fail_arr.length; j++) {
                if (fail_arr[j] == temp) {
                    if (answer[j] == 0) {
                        answer[j] = i;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}