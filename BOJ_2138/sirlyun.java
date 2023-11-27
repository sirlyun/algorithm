package algo_java.src;

import java.io.*;
import java.util.*;

/*
    N개의 스위치와 N개의 전구가 있다
    각각의 전구는 켜져있는 상태와 꺼져있는 상태가 존재
    i(1<i<N)번 스위치를 누르면 i-1, i, i+1의 전구 상태가 바뀐다
    N개의 전구들의 현재 상태와 우리가 만들고자 하는 상태가 주어졌을 때
    그 상태를 만들기 위해 스위치를 최소 몇 번 눌러야 하는가
    만들 수 없을 경우에는 -1 출력
 */

public class Main {

    static int N;

    static int[] want;
    static int[] og1, og2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        // 전구 수
        N = Integer.parseInt(st.nextToken());
        // 원래 전구 상태
        og1 = new int[N];
        og2 = new int[N];
        // 되고 싶은 상태
        want = new int[N];

        st = new StringTokenizer(br.readLine());
        String tmp1 = st.nextToken();
        for (int n=0; n<N; n++){
            og1[n] = Integer.parseInt(String.valueOf(tmp1.charAt(n)));
            og2[n] = Integer.parseInt(String.valueOf(tmp1.charAt(n)));
        }

        st = new StringTokenizer(br.readLine());
        String tmp2 = st.nextToken();
        for (int n=0; n<N; n++){
            want[n] = Integer.parseInt(String.valueOf(tmp2.charAt(n)));
        }

        // 0번 스위치를 킨 경우
        change(og1, 0);
        int cnt1 = 1;
        for (int n=1; n<N; n++) {
            if (og1[n-1] != want[n-1]) {
                change(og1, n);
                cnt1 += 1;
            }
        }
        // og가 want가 될 수 있는지 체크
        boolean chk1 = true;
        for (int n=0; n<N; n++){
            if (og1[n] != want[n]){
                chk1 = false;
                break;
            }
        }
        // 0번 스위치를 안 킨 경우
        int cnt2 = 0;
        for (int n=1; n<N; n++) {
            if (og2[n-1] != want[n-1]) {
                change(og2, n);
                cnt2 += 1;
            }
        }
        // og가 want가 될 수 있는지 체크
        boolean chk2 = true;
        for (int n=0; n<N; n++){
            if (og2[n] != want[n]){
                chk2 = false;
                break;
            }
        }

        if (chk1 && chk2){
            bw.write(Integer.toString(Math.min(cnt1, cnt2)));
        } else if (chk1){
            bw.write(Integer.toString(cnt1));
        } else if (chk2){
            bw.write(Integer.toString(cnt2));
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
    }

    static void change(int[] og, int idx){
        if (idx-1 >= 0) {
            if (og[idx-1] == 0){
                og[idx-1] = 1;
            } else {
                og[idx-1] = 0;
            }
        }
        if (idx+1 < N) {
            if (og[idx+1] == 0){
                og[idx+1] = 1;
            } else {
                og[idx+1] = 0;
            }
        }

        if (og[idx] == 0){
            og[idx] = 1;
        } else {
            og[idx] = 0;
        }
    }
}