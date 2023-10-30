package algo_java.src;

import java.io.*;
import java.util.*;

/*
    캐릭터는 NxN 크기의 격자의 (0, 0)에 위치해있다
    제일 오른쪽 아래 칸까지 이동해야한다
    동굴의 각 칸마다 도둑루피가 있는데, 이 칸을 지나면 해당 도둑루피의 크기만큼 소지금을 잃게 된다.
    잃는 금액을 최소로 하여 동굴 건너편까지 이동해야 하며, 한 번에 상하좌우 인접한 곳으로 1칸씩 이동할 수 있다.
 */

public class Main {
    static int N;
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int cnt = 0;

        while (true){
            cnt += 1;
            N = Integer.parseInt(br.readLine());

            if (N == 0){
                bw.flush();
                bw.close();
                break;
            }
            // 맵 만들기
            int[][] board = new int[N][N];
            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = dijkstra(board);
            bw.write("Problem " + Integer.toString(cnt) + ": " + Integer.toString(result));
            bw.newLine();
        }

    }

    static int dijkstra(int[][] board){
        Queue<Node> queue = new PriorityQueue<>();
        int[][] distance = new int[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        queue.add(new Node(0, 0, board[0][0]));
        distance[0][0] = board[0][0];

        while (!queue.isEmpty()){
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            int cost = now.cost;

            if (distance[x][y] < cost){
                continue;
            }

            for (int i=0; i<4; i++){
                int di = x + dx[i];
                int dj = y + dy[i];

                if (0<=di && di<N && 0<=dj && dj<N){
                    int nextCost = cost+board[di][dj];
                    if (distance[di][dj] > (nextCost)){
                        distance[di][dj] = nextCost;
                        queue.add(new Node(di, dj, nextCost));
                    }
                }

            }

        }

        return distance[N-1][N-1];
    }
}

class Node implements Comparable<Node>{
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    // 가중치에 따라 정렬
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}