package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1520 {
	// 전역변수
	static int M;	// 지도의 세로 크기
	static int N;	// 지도의 가로 크기
	static int[][] map;		// 지도
	static int[][] dp;		// 기록용
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		
		// 지도 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
	}

	static int dfs(int row, int col) {
		if(row == M-1 && col == N-1) {
			return 1;
		}
		
		// 이미 방문한 지점일 때
		if(dp[row][col] != -1) {
			return dp[row][col];
		}
		
		dp[row][col] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(nr >= 0 && nc >= 0 && nr < M && nc < N) {
				if(map[nr][nc] < map[row][col]) {
					dp[row][col] += dfs(nr, nc);
				}
			}
		}
		return dp[row][col];
	}
}
