class Solution {
    private int answer = 0;
    private int[][] map;
    private int[][] record;
    private int N;
    
    public int solution(int[][] land) {
        // input
        map = land;
        
        N = land.length;
        
        record = new int[N][4];
        
        // 첫번째 행 점수 채우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                record[0][j] = map[0][j];
            }
        }
        
        // 첫번째 행에서 시작
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    // 같은 열은 skip
                    if (j == k) {
                        continue;
                    }
                    
                    record[i][j] = Math.max(record[i][j], record[i - 1][k] + map[i][j]);
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(record[N - 1][i], answer);
        }

        return answer;
    }
}
