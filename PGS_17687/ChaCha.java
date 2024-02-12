class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int len = 0;
        int tube = p;

        // t * m 수 까지 게임 진행
        for (int i = 0; i <= t * m; i++) {
            // n진수로 변환
            String tmp = Integer.toString(i, n).toUpperCase();
            
            // 튜브 순서인지 확인
            for (int j = 0; j < tmp.length(); j++) {
                len++;
                
                // 튜브 순서면
                if (len == tube) {
                    answer += tmp.substring(j, j + 1);
                    // 구할 숫자를 다 구했으면
                    if (answer.length() == t) {
                        break;
                    }
                    
                    // 다음 튜브 순서 만들어주기
                    tube += m;
                }
            }
        }
        
        return answer;
    }
}
