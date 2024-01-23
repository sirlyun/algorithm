import java.util.*;

class Solution {
    private static List<String> list1 = new ArrayList<>();
    private static List<String> list2 = new ArrayList<>();
    
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 중복 집합 만들기
        split(list1, str1);
        split(list2, str2);
        
        // 중복 집합 정렬
        Collections.sort(list1);
		Collections.sort(list2);
        
        // 교집합 만들기
		List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        for (String s : list1) {
            // list2가 list1의 원소를 갖고 있다면
            if (list2.remove(s)) {
                // list2에서 지우고
                // 교집합에 추가
                intersection.add(s);
            }
            
            // 합집합에 계속 추가
            union.add(s);
        }
        
        // 합집합 만들기
        // 나머지 합집합에 추가
        for (String s : list2) {
            union.add(s);
        }
        
        // 자카드 유사도
        double i = intersection.size();
        double u = union.size();
        
        double answer = 0;
        
        // 분모가 0인 경우
        if (union.size() == 0) {
            answer = 1;
        }
        else {
            answer = i / u;
        }
        
        return (int) (answer * 65536);
    }
    
    private static void split(List<String> list, String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            String target = input.substring(i, i + 2);
            
            isLetter(list, target);
        } 
        
    }
    
    private static void isLetter(List<String> list, String input) {
        char first = input.charAt(0);
        char second = input.charAt(1);
        
        if ('a' <= first && first <= 'z' && 'a' <= second && second <= 'z') {
            list.add(input);
        }
    }
}
