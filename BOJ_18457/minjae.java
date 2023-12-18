package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18427 {

	public static void main(String[] args) throws Exception {
		int mod = 10007;	// 나중에 나눌 수

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 학생 수
		int M = Integer.parseInt(st.nextToken());	// 최대 블럭 갯수
		int H = Integer.parseInt(st.nextToken());	// 탑의 높이
		
		// 학생들이 가진 블럭 정보
		int[][] block_info = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				block_info[i][j] = Integer.parseInt(st.nextToken());
				
				// 입력값이 더 없을 경우
				if(!st.hasMoreTokens()) {
					break;
				}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(block_info[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// dp 마련, row는 학생 수, col은 만들어질 탑의 높이, 각 요소는 학생 수 row명이 col크기의 탑을 만들 수 있는 경우의 수
		int[][] dp = new int[N+1][H+1];
		
		// 1명부터 N명까지의 학생들이 크기가 0인 탑을 만들 수 있는 경우의 수는 1가지
		for (int i = 0; i < N+1; i++) {
			dp[i][0] = 1;
		}
		
		// 점화식
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < H+1; j++) {
				dp[i][j] = dp[i-1][j];	// i의 블록을 사용하지 않을 때
				
				// i의 k번째 블록을 사용할 때
				for (int k = 1; k < M+1; k++) {
					int block = block_info[i-1][k-1];
					if(block == 0) continue;
					if(j-block >= 0) {
						dp[i][j] += dp[i-1][j-block];
						dp[i][j] %= mod;
					}
				}
			}
		}
		
		System.out.println(dp[N][H]);
	}

}
