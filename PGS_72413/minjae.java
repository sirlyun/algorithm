import java.util.*;

class Solution {
    // 전역변수
    static ArrayList<Node>[] graph;
    static int A = 0;
    static int B = 0;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // fares[i][0]와 fares[i][1] 중 작은 수부터 위치 변경
        for(int i = 0; i < fares.length; i++) {
            if(fares[i][0] > fares[i][1]) {
                int temp = fares[i][0];
                fares[i][0] = fares[i][1];
                fares[i][1] = temp;
            }
            System.out.print(fares[i])
        }
        
        // 그래프 생성, 정점 1번부터 수행하기 위해 n+1로
        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 해당 정점에서 다른 정점까지 필요한 비용
        for(int i = 0; i < fares.length; i++) {
            graph[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
        }
        
        // 다익스트라
        Dijkstra(n, s, a, b);
        
        int answer = A+B;
        return answer;
    }
    
    static void Dijkstra(int n, int start, int a, int b) {
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        int INF = Integer.MAX_VALUE;
        
        // 배열 값 전부 무한대로 채우기
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        // pq가 빌때까지
        while(!pq.isEmpty()) {
            int now = pq.poll().index;
            
            // 이미 방문한 지점이면 통과
            if(check[now]) {
                continue;
            }
            check[now] = true;
            
            // now와 연결된 정점 비교
            for(Node next : graph[now]) {
                if(dist[next.index] > dist[now] + next.cost) {
                    dist[next.index] = dist[now] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
        for(int i : dist) {
			if(i == INF) System.out.print("무한 ");
			else System.out.print(i+" ");
		}
        A = dist[a];
        B = dist[b];
    }
}

// 각 인덱스 대비 가중치
class Node implements Comparable<Node> {
    int index;
    int cost;
    
    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}