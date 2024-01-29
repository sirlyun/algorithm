import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // n -> k 진수로 바꾸기
        // String으로
        String kJinsu = convert(n, k);
                
        String[] split = kJinsu.split("0+");
                
        for (int i = 0; i < split.length; i++) {
            if (isPrime(split[i])) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    private static boolean isPrime(String input) {
        if (input.isEmpty()) {
            return false;
        }
        
        long target = Long.parseLong(input);
        
        if (target <= 1) {
            return false;
        }
        
        for (int i = 2; i < (int) Math.sqrt(target) + 1; i++) {
            if (target % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private static String convert(int n, int k) {
        int target = n;
                
        if (target < k) {
            return String.valueOf(n);
        }
        
        StringBuffer sb = new StringBuffer();

        while (target >= k) {
            sb.append(String.valueOf(target % k));
            
            target /= k;
        }
        
        sb.append(String.valueOf(target));
        
        return sb.reverse().toString();
    }
}
