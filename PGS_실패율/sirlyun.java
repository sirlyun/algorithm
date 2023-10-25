package algo_java.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/*
    실패율을 구하는 solution 함수를 작성해라
    실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
    실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
 */

public class Main {


    public static void main(String[] args) throws Exception {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] result = solution(N, stages);

        System.out.println(Arrays.toString(result));

    }

    static int[] solution(int N, int[] people) {
        // stage 생성
        int[] stages = new int[N+1];
        // 각 stage 별 통과한 사람들
        int[] check = new int[N];
        // 실패율
        double[] fail = new double[N];
        // 최종 출력
        int[] result = new int[N];

        // 각 stage 별 멈춰있는 사용자 수 저장
        for (int i=0; i<people.length; i++){
            stages[people[i]-1] += 1;
        }

        // 각 stage 별 통과한 사용자 수 저장
        for (int i=0; i<N; i++){
            // stage 번호 할당
            result[i] = i+1;

            for (int j=i+1; j<N+1; j++){
                check[i] += stages[j];
            }
        }

        // 실패율 계산
        for (int i=0; i<N; i++){
            fail[i] = (double) stages[i] / check[i];
        }

        // 실패율 자리 바꾸기 용
        double a = 0;
        // 최종 출력 자리 바꾸기 용
        int b = 0;
        // 실패율이 높은 스테이지 찾아서 앞으로 옮기는데, 대신 실패율이 같으면 작은 번호의 스테이지가 앞에 온다.
        for (int i=0; i<N; i++){
            for (int j=1; j<N-i; j++){
                if (fail[j-1]<fail[j]){
                    a = fail[j-1];
                    fail[j-1] = fail[j];
                    fail[j] = a;

                    b = result[j-1];
                    result[j-1] = result[j];
                    result[j] = b;
                }
            }
        }

        return result;
    }

}