class Solution {
    public int solution(int n) {
        int count = 1;
        
        for (int i = 2; i <= n; i++) {
            int mid = n / i;
            
            // i가 짝수일 때
            if (i % 2 == 0) {
                if (mid - i / 2 + 1 > 0 && i * mid + i / 2 == n) {
                    count += 1;
                }
            }
            // i가 홀수일 때
            else {
                if (mid - i / 2 > 0 && n % i == 0) {
                    count += 1;
                }
            }
        }
        
        return count;
    }
}
