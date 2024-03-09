import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static class CustomFile {
        public String NAME;
        public String HEAD;
        public int number;
        public String TAIL;
        public int index;
        
        public CustomFile(String name, int start, int end, int index) {
            this.NAME = name;
            this.HEAD = name.substring(0, start).toLowerCase();
            this.number = Integer.parseInt(name.substring(start, end + 1));
            this.TAIL = name.substring(end + 1, name.length());
            this.index = index;
        }
    }
    
    private List<CustomFile> list;
    
    public String[] solution(String[] files) {
        list = new ArrayList<>(files.length);
        
        // NAME, HEAD, NUMBER, TAIL, 주어진 순서
        
        for (int i = 0; i < files.length; i++) {
            // 입력
            String target = files[i];
            
            // HEAD, NUMBER, TAIL 나누기
            
            // target을 돌면서 NUMBER의 시작과 끝을 찾아보자
            int start = 0;
            int end = 0;
            
            for (int j = 0; j < target.length(); j++) {
                char element = target.charAt(j);
                
                // 아직 start를 못 찾았고, 숫자면
                if (start == 0 && '0' <= element && element <= '9') {
                    start = j;
                    end = j;
                }
                // start를 찾았고, 숫자면
                else if (start != 0 && '0' <= element && element <= '9') {
                    end = j;
                }
                // start를 찾았고, end도 찾았는데, 숫자가 아니면
                else if (start != 0 && end != 0 && !('0' <= element && element <= '9')) {
                    // 그만 찾아.
                    break;
                }
            }
            
            // String name, int start, int end, int index
            list.add(new CustomFile(target, start, end, i));
        }
        
        // 정렬
        List<CustomFile> result = list.stream()
            .sorted((a, b) -> {
                    // HEAD 사전 순
                    if (a.HEAD.equals(b.HEAD)) {
                        // NUMBER 숫자 순
                        return a.number - b.number;
                    }

                    return a.HEAD.compareTo(b.HEAD);
                }
           )
            .collect(Collectors.toList());
        
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).NAME;
        }
        
        return answer;
    }
}
