class Solution {
    private static int[] fibos = new int[100001];
    
    public int solution(int n) {
        fibos[1] = 1;
        
        return fibo(n);
    }
    
    private static int fibo(int input) {
        if (input == 1 || input == 2) {
            return 1;
        }
        
        if (fibos[input] == 0) {
            return fibos[input] = (fibo(input - 1) + fibo(input - 2)) % 1234567;
        }
        else {
            return fibos[input];
        }
    }
}
