class Solution {
    private static int left;
    private static int right;
    private static int count = 0;
    
    public int solution(int n, int a, int b) {
        left = a;
        right = b;
        
        while (right != left) {
            left = newTeam(left);
            right = newTeam(right);
            
            count += 1;
        }

        return count;
    }
    
    private static int newTeam(int input) {
        if (input % 2 == 1) {
            return input / 2 + 1;
        }
        else {
            return input / 2;
        }
    }
}
