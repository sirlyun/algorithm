package algo_java.src;

import java.io.*;
import java.util.*;

/*
    회전하는 벨트 위에 여러가지 종류의 초밥이 놓여있다
    초밥의 종류는 번호로 표현
    벨트 위에는 같은 종류의 초밥이 둘 이상 있을 수 있다

    진행하는 행사
        벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 쿠폰 받음?
        각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행하고,
        쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공
        만약 이 번호에 적혀진 초밥이 현재 벨트 위에 없을 경우, 요리사가 새로 만들어 손님에게 제공

    회전 초밥 음식점의 벨트 상태, 메뉴에 있는 초밥의 가짓수, 연속해서 먹는 접시의 개수, 쿠폰 번호가 주어졌을 때,
    손님이 먹을 수 있는 초밥 가짓수의 최댓값은?
 */

public class Main {

    static int N, k, c;
    static int[] foods;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        // 접시의 개수
        N = Integer.parseInt(st.nextToken());

        // 초밥 종류 개수
        int d = Integer.parseInt(st.nextToken());

        // 연속으로 먹는 접시 수
        k = Integer.parseInt(st.nextToken());

        // 쿠폰 번호
        c = Integer.parseInt(st.nextToken());
//        List<Integer> cIdx = new ArrayList<>();

        foods = new int[N];

        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());

            foods[n] = now;
        }

        int [] check = new int[d+1];
        int count = 0;

        for(int i=0; i<k; i++) {
            if(check[foods[i]] == 0) {
                count++;
            }
            check[foods[i]]++;
        }
        int result = count;

        if(check[c]==0) {
            result = Math.max(result, count+1);
        }
        else {
            result = Math.max(result, count);
        }

        int start = 1;
        int end = k;

        while (true) {

            if(check[foods[start-1]] == 1) {
                count--;
            }
            check[foods[start-1]]--;

            if(check[foods[end]] == 0) {
                count++;
            }
            check[foods[end]]++;

            if(check[c]==0) {
                result = Math.max(result, count+1);
            }
            else {
                result = Math.max(result, count);
            }

            start++;
            end++;

            if(end == N) {
                end=0;
            }

            if(start == N) {
                break;
            }
        }

        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();

    }


}