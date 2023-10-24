package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17825 {
	// 전역변수
	// 게임판
	static int[][] board = {
		{0, 2, 4, 6, 8, 10}, // 0번째 움직임
		{10, 13, 16, 19, 25}, // 1번째 움직임
		{10, 12, 14, 16, 18, 20},
		{20, 22, 24, 25},
		{20, 22, 24, 26, 28, 30},
		{30, 28, 27, 26, 25},
		{30, 32, 34, 36, 38, 40},
		{25, 30, 35, 40},
		{40, 0} // 8번째 움직임
	};
	
	// 방문처리
	static int[][] visited = {
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 0}
	};
	static int score = 0;	// 최대 점수
	static int[] dice = new int[10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 주사위
		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		// 말의 위치와 움직임
		int[][] yut = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};
		
		game(0, yut, 0);
	}

	static void game(int cnt, int[][] y, int s) {
		if(cnt >= 10) {
			score = Math.max(score, s);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(y[i][0] == 8 && y[i][1] == 1) {
				continue;
			}
			
			int sr = y[i][0];	// 현재 움직임
			int sc = y[i][1];	// 현재 위치
			int cr = y[i][0];	// 다음 움직임
			int cc = y[i][1] + dice[cnt];	// 다음 위치
			
			if(cc == board[cr].length-1) {
				// 다음 위치가 방향의 마지막 부분이면
				if(cr < 6 && cr%2 == 0) {
					// 0 -> 1, 2 -> 3, 4 -> 5
				}
			}
		}
	}
}
