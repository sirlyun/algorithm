class Solution {
    public int solution(int[] arr) {
        
        if (arr.length == 1){
            return arr[0];
        }
        
        int gcd = getGcd(arr[0], arr[1]);
        int answer = (arr[0] * arr[1]) / gcd;
        
        for (int i=2; i<arr.length; i++){
            gcd = getGcd(answer, arr[i]);
            answer = (answer * arr[i]) / gcd;
        }
        
        return answer;
    }
    
    public int getGcd(int a, int b){
        if (a % b == 0){
            return b;
        }
        
        return getGcd(b, a % b);
    }
}