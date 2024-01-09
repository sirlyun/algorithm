import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int[] answer = new int[2];
        
        List<String> wordGame = new ArrayList<>();
        wordGame.add(words[0]);
        
        for (int i=1; i<words.length; i++){
            // 끝말잇기 규칙 체크
            String[] lastWord = wordGame.get(wordGame.size()-1).split("");
            String[] checkWord = words[i].split("");
            
            if (lastWord[lastWord.length-1].equals(checkWord[0])){
                String check = String.join("", checkWord);
                if (!wordGame.contains(check)){
                    wordGame.add(check);
                } else{
                    answer[0] = i%n + 1;
                    answer[1] = i/n + 1;
                    break;
                }
            } else{
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }
        }

        return answer;
    }
}