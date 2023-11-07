package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1135 {
	// 전역변수
	static int N;
	static int[] arr;
	static List<ArrayList<Integer>> relation = new ArrayList<>();
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());	// 직원 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		
		st.nextToken();		// 민식이 값 -1 버리기
		relation.add(new ArrayList<>());	// 민식이 인덱스
		
		// 상사 인덱스에 직속부하가 누구인지 리스트에 담기
		for (int i = 1; i < N; i++) {
			relation.add(new ArrayList<>());
			int chk = Integer.parseInt(st.nextToken());
			relation.get(chk).add(i);
		}
		
		int result = dfs(0);
		System.out.println(result);
	}

	static int dfs(int now) {
		int cnt = 0;
		int maxCnt = 0;
		Queue<Node> q = new PriorityQueue<>();
		
		// 자식 탐색
		for (Integer next : relation.get(now)) {
			// 자식이 가지고 있는 자식들의 수 저장
			dp[next] += dfs(next);
			
			// cost 가중치로 우선순위 큐에 추가, cost는 자식 수
			q.add(new Node(next, dp[next]));
		}
		
		// 깊이가 더 깊은 자식에 대해서 maxCnt 저장
		while(!q.isEmpty()) {
			Node node = q.poll();
			cnt++;
			maxCnt = Math.max(maxCnt, node.cost + cnt);
		}
		
		return maxCnt;
	}
	
}

//노드 참 어렵다...  코스트에 가중치를 두는 노드
class Node implements Comparable<Node> {
	int idx;
	int cost;
	
	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return o.cost - this.cost;
	}
}