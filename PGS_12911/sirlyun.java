class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        int ogCount = 0;
        String ogToBinary = Integer.toBinaryString(n);
        for (int i=0; i<ogToBinary.length(); i++){
            if (ogToBinary.charAt(i) == '1'){
                ogCount++;
            }
        }
        
        for (int i=n+1; i<=1000000; i++){
            int newCount = 0;
            String newToBinary = Integer.toBinaryString(i);
            for (int j=0; j<newToBinary.length(); j++){
                if (newToBinary.charAt(j) == '1'){
                    newCount++;
                }
            }
            
            if (newCount == ogCount){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}