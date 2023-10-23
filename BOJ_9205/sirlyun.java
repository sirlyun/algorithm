package algo_java.src;

import java.io.*;
import java.util.*;
/*
    상근이 집에서 출발하고 맥주 한 박스를 가지고 시작한다.
    맥주 한 박스에는 20개가 들어있다.
    50미터 걸어가는데 한병 먹어야함
    편의점에 들렀을 때 빈병버리고 한병 사는거 가능
    근데 맥주 박스는 20병 넘게 못담음
    편의점을 나선 직후에도 50미터 가기전에 한병 먹어야함
    행복하게 페스티벌에 갈 수 있으면 "happy", 중간에 맥주가 바닥나서 더 이동할 수 없으면 "sad"를 출력
 */

public class Main {
    static int n,sx,sy,ex,ey;
    public static void main(String[] args) throws IOException {
        // 입력 스트림
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 스트림
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        // 테스트 케이스
        int t = Integer.parseInt(br.readLine());
        for (int tc=0; tc<t; tc++){
            // 편의점 개수
            n = Integer.parseInt(br.readLine());
            // 2차원 리스트 선언
            List<int[]> list = new ArrayList<>();
            // x좌표 y좌표 받기
            for(int i=0; i<n+2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                // 시작점, 끝점 / 편의점 위치는 리스트에 추가
                if(i==0) {
                    sx = x;
                    sy = y;
                }else if(i==n+1) {
                    ex = x;
                    ey = y;
                }else {
                    list.add(new int[]{x,y});
                }
            }

            boolean check = bfs(list);
            if (check){
                bw.write("happy\n");

            }else {
                bw.write("sad\n");
            }

//            for (int[] coordinates : list) {
//                System.out.println("x: " + coordinates[0] + ", y: " + coordinates[1]);
//            }
        }

        // 스트림 비우기
        bw.flush();
        // 스트림 닫기
        bw.close();
    }

    static boolean bfs(List<int[]> list) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        // 시작점 넣어주기
        q.add(new int[] {sx,sy});
        while(!q.isEmpty()) {
            // 현재 x, y 할당
            int[] now = q.poll();
            int x = now[0], y = now[1];
            // 종료 지점과 맨해튼거리 1000 이내면 도착 가능
            if(Math.abs(x-ex) + Math.abs(y-ey) <= 1000) {
                return true;
            }

            for(int i=0; i<n; i++) {
                // 다음으로 갈 편의점 정하기
                if(!visited[i]) {
                    int nx = list.get(i)[0], ny = list.get(i)[1];
                    int dis = Math.abs(x - nx) + Math.abs(y - ny);
                    // 맥주 20병 안에 도착 가능한 편의점이면 가기
                    if(dis <= 1000) {
                        visited[i] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return false;
    }
}