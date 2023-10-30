package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4485 {
	// 전역변수
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static boolean visit[][];
	static int[][] cave;
	static int[][] size;
	
	private static final int INF = Integer.MAX_VALUE / 4;
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

		while(true) {
			int N = Integer.parseInt(br.readLine());	// 동굴의 크기
			if(N == 0) {
				break;	// 입력이 0이면 반복 종료
			}
			
			// 동굴 입력
			cave = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
		}
		
	}

}
