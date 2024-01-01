import java.util.*;

class Solution {
    private static StringBuffer sb = new StringBuffer();
    private static List<Integer> list = new ArrayList<>();
    private static int answer = 0;
    private static int left;
    private static int right;
    
    public int solution(int[] people, int limit) {
        left = 0;
        right = people.length - 1;
        
        // 입력
        for (int i = 0; i < people.length; i++) {
            list.add(people[i]);
        }
        
        // 정렬
        list.sort(Comparator.reverseOrder());
        
        // 반복
        while (left <= right) {
            if (left == right) {
                answer += 1;
                break;
            }
            
            int current = list.get(left);
            
            // 몸무게 가장 작은 사람 가능한지 확인
            int sum = current + list.get(right);
            
            if (sum <= limit) {
                right -= 1;
            }
            
            left += 1;
            
            answer += 1;
        }
        
        return answer;
    }
}
