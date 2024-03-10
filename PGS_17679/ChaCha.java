import java.util.*;

class Solution {    
    private Character[][] arr;
    private int answer = 0;
    private int[] dx = {0, 0, 1, 1};
    private int[] dy = {0, 1, 0, 1};
    
    public int solution(int m, int n, String[] board) {
        // 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임
        
        // 지워지는 블록은 모두 몇 개?
        
        // 높이 m, 폭 n
        
        // 판 만들기
        arr = new Character[board.length][board[0].length()];
        
        for (int i = 0; i < board.length; i++) {
            String line = board[board.length - i - 1];
            
            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        
        while (true) {
            List<int[]> result = find();
            
            if (result.size() == 0) {
                break;
            }
            
            removeAndFall(result);
        }
        
        return answer;
    }
    
    // 2x2를 찾는 메소드
    private List<int[]> find() {
        List<int[]> result = new LinkedList<>();
        
        for (int h = 0; h < arr.length - 1; h++) {
            for (int w = 0; w < arr[0].length - 1; w++) {
                // null이면 다음
                if (arr[h][w] == null) {
                    continue;
                }
                
                // 4개가 전부 같으면
                if (arr[h][w] == arr[h + 1][w] && arr[h + 1][w] == arr[h][w + 1] && arr[h][w + 1] == arr[h + 1][w + 1]) {
                    result.add(new int[] {h, w});
                }
            }
        }
        
        return result;
    }
    
    // 지우고 내리는 메소드
    private void removeAndFall(List<int[]> list) {
        int count = 0;
        
        // 지우자
        for (int[] target : list) {
            for (int i = 0; i < 4; i++) {
                int h = target[0] + dy[i];
                int w = target[1] + dx[i];
                
                if (arr[h][w] != null) {
                    count += 1;
                }
                
                arr[h][w] = null;
            }
        }
        
        // 내리자
        for (int w = 0; w < arr[0].length; w++) {
            // 살아남은 애들 찾기
            List<Character> survivors = new LinkedList<>();
            for (int h = 0; h < arr.length; h++) {
                if (arr[h][w] != null) {
                    survivors.add(arr[h][w]);
                }
            }
            
            // 살아남은 애들로 덮어씌우기
            for (int e = 0; e < survivors.size(); e++) {
                arr[e][w] = survivors.get(e);
            }
            
            // 나머지는 비우기
            for (int i = survivors.size(); i < arr.length; i++) {
                arr[i][w] = null;
            }
        }
        
        answer += count;
    }
}
