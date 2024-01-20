/*
    카펫에 무슨 색이 몇 개 칠해져있는지는 기억하지만
    전체 카펫의 크기는 모름
    중앙은 노란색이고 테두리 한줄은 갈색이다
    카펫의 크기 = brown + yellow = width * height
    노란색 부분의 크기 = (width - 2) * (height - 2)  
*/

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        // 카펫의 크기
        int carpet = brown + yellow;
        
        for (int i=3; i<carpet; i++){
            if (carpet % i == 0){
                int j = carpet / i;
                if ((j >= i) && (j-2)*(i-2) == yellow){
                    answer[0] = j;
                    answer[1] = i;
                }
            }
            
        }
        
        return answer;
    }
}