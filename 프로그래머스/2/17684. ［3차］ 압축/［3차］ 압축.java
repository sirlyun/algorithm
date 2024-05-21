/*
    압축 과정
        1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화
        2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
        3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거
        4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c),
        w+c에 해당하는 단어를 사전에 등록
        5. 2단계로 돌아가기
*/

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> book = new ArrayList<>();
        for (int i=65; i<91; i++) {
            book.add(String.valueOf((char)i));
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<msg.length(); i++){
            for (int j=book.size()-1; j>=0; j--) {
                if (msg.substring(i).startsWith(book.get(j))) {
                    i += book.get(j).length()-1;
                    result.add(j+1);
                    if(i+1 < msg.length()) {
                        book.add(book.get(j)+msg.charAt(i+1));
                    }
                    break;
                }
            }
        }
            
        int[] answer = new int[result.size()];

        for(int i = 0 ; i < result.size() ; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}