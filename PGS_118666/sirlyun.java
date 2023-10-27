package algo_java.src;

import java.io.*;
import java.util.*;

/*
    1번 지표	라이언형(R), 튜브형(T)
    2번 지표	콘형(C), 프로도형(F)
    3번 지표	제이지형(J), 무지형(M)
    4번 지표	어피치형(A), 네오형(N)
    -> 성격 유형은 총 16가지가 나올 수 있다
    검사지에는 n개의 질문이 있고 각각 7가지의 답변이 있다
        매우 비동의 : 선택지를 선택하면 3점을 얻습니다.
        비동의 : 선택지를 선택하면 2점을 얻습니다.
        약간 비동의 : 선택지를 선택하면 1점을 얻습니다.
        모르겠음 : 선택지를 선택하면 점수를 얻지 않습니다.
        약간 동의 : 선택지를 선택하면 1점을 얻습니다.
        동의 : 선택지를 선택하면 2점을 얻습니다.
        매우 동의 : 선택지를 선택하면 3점을 얻습니다.
    검사 결과는 모든 질문의 성격 유형 점수를 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형이라고 판단합니다.
    ** 단, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단합니다.
    질문마다 판단하는 지표를 담은 1차원 문자열 배열 survey와 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열 choices가 매개변수로 주어집니다.
    이때, 검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return
 */

public class Main {

    public static void main(String[] args) throws IOException {

        String[] survey = {"AN"};
        int[] choices = {7};

        System.out.println(solution(survey, choices));

    }

    static String solution(String[] survey, int[] choices) {
        String[] og = {"RT", "CF", "JM", "AN"};
        String[] rv = {"TR", "FC", "MJ", "NA"};

        int[][] chk = {
                {0, 0}, {0, 0}, {0, 0}, {0, 0}
        };
        
        String answer = "";

        // 점수 주기
        for (int i=0; i<survey.length; i++){
            int left = 0;
            int right = 0;
            int now = 0;

            for (int j=0; j<4; j++){
                if (survey[i] == og[j]){
                    now = j;
                    if (choices[i] < 4){
                        left += (4 - choices[i]);
                    } else if (choices[i] > 4) {
                        right += (choices[i] - 4);
                    }
                    break;
                } else if (survey[i] == rv[j]) {
                    now = j;
                    if (choices[i] < 4){
                        right += (4 - choices[i]);
                    } else if (choices[i] > 4) {
                        left += (choices[i] - 4);
                    }
                    break;
                }
            }

            chk[now][0] += left;
            chk[now][1] += right;
        }

        for (int i=0; i<chk.length; i++){
            if (chk[i][0] == chk[i][1]){
                answer += og[i].charAt(0);
            } else if (chk[i][0] < chk[i][1]){
                answer += og[i].charAt(1);
            } else {
                answer += og[i].charAt(0);
            }
        }


        return answer;
    }
}