package algo_java.src;

/*
    무지는 자신이 택시를 이용할 때 동료인 어피치 역시
    자신과 비슷한 방향으로 가는 택시를 종종 이용하는 것을 알게됨

    무지는 어피치와 택시 합승을 적절히 이용하면 택시 요금을 얼마나 아낄지 계산해보고
    어피치에게 합승을 제안한다

    지점이 n개일 때 지점 번호는 1부터 n까지 사용

*/

import java.util.*;

class Solution {

    static List<ArrayList<int[]>> graph = new ArrayList<>();
    static int N;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;

        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<int[]>());
        }

        for(int[] fare : fares){
            graph.get(fare[0]).add(new int[] {fare[1], fare[2]});
            graph.get(fare[1]).add(new int[] {fare[0], fare[2]});
        }

        // start에서 출발해서 각 위치마다 가는 최단거리 찾기
        int[] together = dijkstra(s);
        int answer = Integer.MAX_VALUE;

        for (int i=1; i<N+1; i++){
            // 각 위치에서 a와 b에 최단거리로 도착하는거 찾기
            int[] alone = dijkstra(i);
            int cost = together[i] + alone[a] + alone[b];
            answer = Math.min(answer, cost);
        }


        return answer;
    }

    static int[] dijkstra(int start){

        Queue<Node> queue = new PriorityQueue<>();
        int[] distance = new int[N+1];
        for (int n=0; n<N+1; n++){
            distance[n] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()){
            Node now = queue.poll();

            if (distance[now.idx] < now.cost){
                continue;
            }

            for (int[] next : graph.get(now.idx)){
                int nextCost = now.cost + next[1];
                if (distance[next[0]] > nextCost){
                    distance[next[0]] = nextCost;
                    queue.add(new Node(next[0], nextCost));
                }
            }
        }

        return distance;

    }
}

class Node implements Comparable<Node>{
    int idx;
    int cost;

    public Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}