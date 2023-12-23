import java.util.*;

class Solution {
    private static Set<String> wordStorage = new HashSet<>();
    private static String formal;
    private static String newWord;
    
    public int[] solution(int n, String[] words) {
        formal = words[0];
        
        // 한 글자인 단어는 인정되지 않습니다.
        if (formal.length() == 1) {
            return new int[] {1, 1};
        }
        
        wordStorage.add(formal);
        
        for (int i = 1; i < words.length; i++) {            
            newWord = words[i];
            
            // 한 글자인 단어는 인정되지 않습니다.
            if (newWord.length() == 1) {
                return new int[] {i % n + 1, i / n + 1};
            }
            
            // 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
            if (formal.charAt(formal.length() - 1) != newWord.charAt(0)) {
                return new int[] {i % n + 1, i / n + 1};
            }
            
            int previousSize = wordStorage.size();
            wordStorage.add(newWord);
            int nextSize = wordStorage.size();
            
            // 이전에 등장했던 단어는 사용할 수 없습니다.
            if (previousSize == nextSize) {
                return new int[] {i % n + 1, i / n + 1};
            }
            
            formal = newWord;
        }

        return new int[] {0, 0};
    }
}
