package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18430 {
	// 전역 변수
	static int N;
	static int M;
	static int[][] tree;
	static boolean[][] visited;
	static int max_s = 0;
	static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 재료의 N줄
		M = Integer.parseInt(st.nextToken());	// 재료의 M칸
		
		// 나무 재료 입력 받기
		tree = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backtracking(0, 0);
		System.out.println(max_s);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.println(tree[i][j]);
//			}
//		}
	}

	static void backtracking(int idx, int cnt) {
//		if(cnt == 2) {
//			if(max_s < s) {
//				max_s = s;
//			}
//			return;
//		}
		
		// 첫 번째 값 찾기
		for (int i = idx; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]) {

					// ㄱ자부터 시계방향으로 4번
					for (int k = 0; k < 4; k++) {
						int nr1 = i + dr[k];
						int nc1 = j + dc[k];
						
						int nr2 = i + dr[(k+1)%4];
						int nc2 = j + dc[(k+1)%4];
						
						if(nr1 >= 0 && nr1 < N && nc1 >= 0 && nc1 < M
								&& nr2 >= 0 && nr2 < N && nc2 >= 0 && nc2 < M) {
							if(!visited[nr1][nc1] && !visited[nr2][nc2]) {
								visited[i][j] = true;
								visited[nr1][nc1] = true;
								visited[nr2][nc2] = true;
								backtracking(i, cnt + 2*tree[i][j] + tree[nr1][nc1] + tree[nr2][nc2]);
								visited[i][j] = false;
								visited[nr1][nc1] = false;
								visited[nr2][nc2] = false;
							}
						}
					}
				}
			}
		}
		max_s = Math.max(max_s, cnt);
	}
}
