class Solution {
    private int[] arr = new int[60_001];
    
    public int solution(int n) {
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        
        return dp(n);
    }
    
    private int dp(int target) {
        if (target <= 3) {
            return arr[target];
        }
        
        if (arr[target] == 0) {
            return arr[target] = (dp(target - 1) + dp(target - 2)) % 1_000_000_007;
        }
        
        return arr[target];
    }
}
