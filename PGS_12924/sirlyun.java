class Solution {
    public int solution(int n) {
        
        int answer = 1;
        
        for (int i=1; i<=n; i++){
            int check = i;
            
            for(int j=i+1; j<=n; j++){
                if (check == n){
                    answer += 1;
                    break;
                } else if (check > n){
                    break;
                }
                
                check += j;
            }
        }
        
        return answer;
    }
}