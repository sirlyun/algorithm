package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18430 {
	// 전역 변수
	static int N;
	static int M;
	static int[][] tree;
	static int max_s = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 재료의 N줄
		M = Integer.parseInt(st.nextToken());	// 재료의 M칸
		
		// 나무 재료 입력 받기
		tree = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backtracking(0, visited, 0);
		System.out.println(max_s);
	}

	static void backtracking(int s, boolean[][] visit, int cnt) {
		if(cnt == 2) {
			if(max_s < s) {
				max_s = s;
			}
			return;
		}
		
		// 배열 복사
		boolean[][] v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = visit[i][j];
			}
		}
		
		int r = -1;
		int c = -1;
		
		// 첫 번째 값 찾기
		int strength1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!v[i][j]) {
					r = i;
					c = j;
					
					// ㄴ자부터 시계방향으로 4번
					for (int k = 0; k < 4; k++) {
						int temp1 = 0;
						switch(k) {
							case 0:
								if((r-1) >= 0 && (c+1) < M) {
									temp1 = (tree[r][c]*2) + tree[r-1][c] + tree[r][c+1];
								}
								break;
							case 1:
								if((r+1) < N && (c+1) < M) {
									temp1 = (tree[r][c]*2) + tree[r+1][c] + tree[r][c+1];
								}
								break;
							case 2:
								if((r+1) < N && (c-1) >= 0) {
									temp1 = (tree[r][c]*2) + tree[r+1][c] + tree[r][c-1];
								}
								break;
							case 3:
								if((r-1) >= 0 && (c-1) >= 0) {
									temp1 = (tree[r][c]*2) + tree[r-1][c] + tree[r][c-1];
								}
								break;
						}
						if(strength1 < temp1) {
							strength1 = temp1;
							v[r][c] = true;
							switch(k) {
								case 0:
									v[r-1][c] = true;
									v[r][c+1] = true;
									break;
								case 1:
									v[r+1][c] = true;
									v[r][c+1] = true;
									break;
								case 2:
									v[r+1][c] = true;
									v[r][c-1] = true;
									break;
								case 3:
									v[r-1][c] = true;
									v[r][c-1] = true;
									break;
							}
						}
					}
					backtracking(s + strength1, v, cnt+1);
				}
			}
		}
	}
}
