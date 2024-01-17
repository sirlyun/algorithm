class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {        
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int m = 0; m < arr1.length; m++) {            
            for (int n = 0; n < arr2[0].length; n++) {
                int sum = 0;
                
                for (int i = 0; i < arr1[0].length; i++) {
                    sum += arr1[m][i] * arr2[i][n];
                }
                
                answer[m][n] = sum;
            }
        }
        
        return answer;
    }
}
