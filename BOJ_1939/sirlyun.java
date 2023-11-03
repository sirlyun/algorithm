package algo_java.src;

import java.io.*;
import java.util.*;

/*
    N개의 섬으로 이루어진 나라
    이들 중 몇개의 섬 사이에는 다리가 설치되어 있어 차들이 지나다닐 수 있다
    두 개의 섬에 공장을 세워 두고 물품을 생산하는 일을 하고 있다
    각각의 다리마다 중량제한이 있어 초과하는 양만큼 물품을 이동시킬 수 없다
    한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값은?
 */

public class Main {

    static int N, M, start, end;
    static int result = 0;
    static List<List<int[]>> lands = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<N+1; i++){
            lands.add(new ArrayList<>());
        }

        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            lands.get(a).add(new int[] {b, w});
            lands.get(b).add(new int[] {a, w});
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        chooseWeight();

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }

    static boolean bfs(int weight){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();

            for (int[] next : lands.get(now)){
                if (!visited[next[0]] && next[1] >= weight){
                    // 도착지면 바로 탈출
                    if (next[0] == end){
                        return true;
                    }
                    visited[next[0]] = true;
                    queue.add(next[0]);
                }
            }
        }


        return false;
    }

    static void chooseWeight(){
        // 중량 최소
        int s = 1;
        //중량 최대
        int e = 1000000000;

        while (s<=e){
            // 현재 중량
            int mid = (s+e)/2;
            // 이 중량 이동 가능한지 체크
            boolean check = bfs(mid);

            if (check){
                result = mid;
                s = mid+1;
            }else {
                e = mid-1;
            }
        }

    }

}

