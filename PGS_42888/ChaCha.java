import java.util.*;

class Solution {
    private Map<String, String> map = new HashMap<>();
    private List<String> histories = new ArrayList<>();
    
    public String[] solution(String[] record) {        
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            
            String command = st.nextToken();
            String id = st.nextToken();
            String nickname;
            
            if (!command.equals("Leave")) {
                nickname = st.nextToken();
                
                // Enter
                if (command.equals("Enter")) {
                    map.put(id, nickname);
                }
                // Change
                else {
                    map.put(id, nickname);
                }
            }
            
            if (!command.equals("Change")) {
                histories.add(command);
                histories.add(id);
            }
        }
        
        String[] answer = new String[histories.size() / 2];
        for (int i = 0; i < answer.length; i++) {
            String command = histories.get(i * 2);
            String id = histories.get(i * 2 + 1);
            
            if (command.equals("Enter")) {
                command = " 들어왔습니다.";
            }
            else {
                command = " 나갔습니다.";
            }
            
            answer[i] = map.get(id) + "님이" + command;
        }
        
        return answer;
    }
}
