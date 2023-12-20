class Solution {
    private static int newNumber;
    private static int newNumberCount;
    
    public int solution(int n) {
        newNumber = n;
        
        int answer = 0;
        
        int count = Integer.bitCount(n);
        
        while (true) {
            newNumber += 1;
            
            newNumberCount = Integer.bitCount(newNumber);
            
            if (count == newNumberCount) {
                answer = newNumber;
                break;
            }
        }
        
        return answer;
    }
}
