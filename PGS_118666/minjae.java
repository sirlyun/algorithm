class Solution {
    // 전역변수
    static int[] mbti = new int[4];
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        // survey를 순회
        for(int i=0; i < survey.length; i++) {
            switch(choices[i]) {
                case 1:
                    paper(survey[i].charAt(0), 3);
                    break;
                case 2:
                    paper(survey[i].charAt(0), 2);
                    break;
                case 3:
                    paper(survey[i].charAt(0), 1);
                    break;
                case 5:
                    paper(survey[i].charAt(1), 1);
                    break;
                case 6:
                    paper(survey[i].charAt(1), 2);
                    break;
                case 7:
                    paper(survey[i].charAt(1), 3);
                    break;
            }
        }
        
        char[][] arr = {
            {'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}
        };
        
        for(int i=0; i < 4; i++) {
            if(mbti[i] <= 0) {
                answer += arr[i][0];
            }else if(mbti[i] > 0) {
                answer += arr[i][1];
            }
        }
        
        return answer;
    }
    
    static void paper(char c, int p) {
        int point = p;
        if(c == 'R' || c == 'C' || c == 'J' || c == 'A') {
            point = -p;
        }
        
        // 점수 입력하기
        if(c == 'R' || c == 'T') {
            mbti[0] += point;
        }
        else if(c == 'C' || c == 'F') {
            mbti[1] += point;
        }
        else if(c == 'J' || c == 'M') {
            mbti[2] += point;
        }
        else {
            mbti[3] += point;
        }
    }
}