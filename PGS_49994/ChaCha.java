import java.util.*;

class Solution {
    private Map<String, Character> record = new HashMap<>();
    private int[] current = {0, 0};
    private int answer = 0;
    
    public int solution(String dirs) {        
        for (int i = 0; i < dirs.length(); i++) {
            move(dirs.charAt(i));
        }
        
        return answer;
    }
    
    private void move(char command) {
        int nextX = current[0];
        int nextY = current[1];
        
        if (command == 'U') {
            nextY += 1;
        }
        else if (command == 'D') {
            nextY -= 1;
        }
        else if (command == 'R') {
            nextX += 1;
        }
        else if (command == 'L') {
            nextX -= 1;
        }
        
        // 밖을 나가면
        if (nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5) {
            // 무시
            return;
        }
        
        String result1 = "";
        result1 += String.valueOf(current[0]);
        result1 += String.valueOf(current[1]);
        result1 += String.valueOf(nextX);
        result1 += String.valueOf(nextY);
        
        String result2 = "";
        result2 += String.valueOf(nextX);
        result2 += String.valueOf(nextY);
        result2 += String.valueOf(current[0]);
        result2 += String.valueOf(current[1]);
        
        // 안나갔으면
        // 이동
        current[0] = nextX;
        current[1] = nextY;
                
        // 없으면
        // record에 기록
        if (record.getOrDefault(result1, '0') == '0') {
            record.put(result1, '1');
            record.put(result2, '1');
            answer += 1;
        }
    }
}
