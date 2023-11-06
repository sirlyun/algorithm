class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];    // 지도
        
        // 초기 세팅에서 웅덩이가 있으면 0으로 변경
        for(int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        map[0][0] = 1;
        
        // 학교까지 가는 경우의 수를 더해가며 추가
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 해당 지역이 물 웅덩이가 아닐 때
                if(map[i][j] != -1) {
                    if(i > 0 && map[i-1][j] != -1) {
                        map[i][j] += map[i-1][j];
                    }
                    if(j > 0 && map[i][j-1] != -1) {
                        map[i][j] += map[i][j-1];
                    }
                    if(map[i][j] > 1000000007) {
                        map[i][j] %= 1000000007;
                    }
                }
            }
        }
        
        // 최종 결과를 1,000,000,007로 나눈 나머지를 answer로 리턴
        answer = map[n-1][m-1];
        
        return answer;
    }
}