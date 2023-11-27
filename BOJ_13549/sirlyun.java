package algo_java.src;

import java.io.*;
import java.util.*;

/*
    수빈이와 동생은 숨바꼭질 중
    수빈이는 현재 점 N에 있다.
    동생은 점 K에 있다.
    수빈이는 걷거나 순간이동을 할 수 있다.
    만약 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
    순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
    수빈이와 동생의 위치가 주어졌을 때 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇초 후인지 구하는 프로그램을 작성해라
 */

public class Main {

    static int N, K;
    static boolean[] visited;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        // 수빈이의 위치
        N = Integer.parseInt(st.nextToken());
        // 동생의 위치
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        bfs(N);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();


    }

    static void bfs(int start){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()){
            Node now = queue.poll();

            if (now.idx == K){
                result = Math.min(result, now.time);
                return;
            }

            if (now.idx*2<100001 && !visited[now.idx*2]){
                queue.add(new Node(now.idx*2, now.time));
                visited[now.idx*2] = true;
            }

            if (now.idx-1>=0 && !visited[now.idx-1]){
                queue.add(new Node(now.idx-1, now.time+1));
                visited[now.idx-1] = true;
            }

            if (now.idx+1<100001 && !visited[now.idx+1]){
                queue.add(new Node(now.idx+1, now.time+1));
                visited[now.idx+1] = true;
            }
        }


    }
}

class Node{
    int idx, time;

    public Node(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }
}