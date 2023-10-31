package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_4485 {
	// 전역변수
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static boolean visit[][];
	static int[][] cave;
	static int[][] size;
	
	private static final int INF = Integer.MAX_VALUE;
	static int N, nr, nc;
	
	// 노드 클래스
	static class Node implements Comparable<Node> {
		// 노드 위치
		int x;
		int y;
		int size;
		
		// 정점번호, 가중치 저장, 생성자
		public Node(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		// cost(=가중치) 중심으로 우선순위가 정해지기 때문에 compareTo 오버라이딩
		// 다른 방법으로 이를 생략하고 우선순위 큐 아래처럼 선언
		/* PriorityQueue<Node> pq = new PriorityQueue<Node>
		 * ((o1, o2) -> Integer.compare(o1.size, o2.size));
		 * 이거는 될지 모르겠다...
		 */
		
		@Override
		public int compareTo(Node o) {
			return size - o.size;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 1;

		while(true) {
			N = Integer.parseInt(br.readLine());	// 동굴의 크기
			if(N == 0) {
				break;	// 입력이 0이면 반복 종료
			}
			
			cave = new int[N][N];
			visit = new boolean[N][N];
			size = new int[N][N];
			
			// 동굴 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					size[i][j] = INF;
				}
			}
			
			bfs(0, 0, cave[0][0]);
			System.out.println("Problem " + cnt + ": " + size[N-1][N-1]);
			cnt++;
		}// while
		
	}
	
	static void bfs(int x, int y, int roopy) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visit[x][y] = true;
		pq.offer(new Node(x, y, roopy));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			for (int i = 0; i < 4; i++) {
				nr = node.x + dr[i];
				nc = node.y + dc[i];
				
				if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if(!visit[nr][nc] && size[nr][nc] > (cave[nr][nc] + node.size)) {
						size[nr][nc] = cave[nr][nc] + node.size;
						visit[nr][nc] = true;
						pq.offer(new Node(nr, nc, size[nr][nc]));
					}
				}
			}
		}
	}

}
