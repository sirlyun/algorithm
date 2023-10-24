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
		
		// 방문처리
		int[][] visited = {
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
		
		game(0, yut, 0, visited);
		System.out.println(score);
	}

	static void game(int cnt, int[][] y, int s, int[][] visited) {
		if(cnt >= 10) {
			score = Math.max(score, s);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(y[i][0] == 8 && y[i][1] == 1) {
				// 말이 8번째 구간이고 도착지점에 도착했을 때면 건너뛰기
				continue;
			}
			
			int sr = y[i][0];	// 현재 구간
			int sc = y[i][1];	// 현재 위치
			int cr = y[i][0];	// 다음 구간
			int cc = y[i][1] + dice[cnt];	// 다음 위치
			
			if(cc == board[cr].length-1) {
				// 다음 위치가 방향의 마지막 부분이면
				if(cr < 6 && cr%2 == 0) {
					// 0번, 2번, 4번 구간일경우 : 1,3,5번 구간으로 이동
					cr++;
					cc = 0;
				}
				else if(cr == 6 || cr == 7) {
					// 6, 7번 구간 : 8번 구간으로 이동
					cr = 8;
					cc = 0;
				}
				else if(cr % 2 == 1) {
					// 1,3,5번 구간 : 7번 구간으로 이동
					cr = 7;
					cc = 0;
				}
				else {
					// 8번 구간 : 주사위에 상관없이 도착
					cc = 1;
				}
			}
			else if(cc >= board[cr].length) {
				// 말의 다음 위치가 현재 구간을 뛰어넘을 경우
				// 착수점을 다음 구간의 인덱스로 변경
				cc = cc - board[cr].length + 1;
				
				if(cr % 2 == 0) {
					// 0,2,4,6,8 구간
					cr += 2;
					if(cr >= 8) {
						cr = 8;
						if(cc >= 1) {
							cc = 1;
						}
					}
				}
				else if(cr == 7) {
					// 7번 구간
					cr = 8;
					if(cc >= 1) {
						cc = 1;
					}
				}
				else {
					// 1,3,5번 구간
					cr = 7;
					
					// 지름길이라 경우에 따라 한번에 8번 구간까지 도달도 가능하다.
					if(cc >= board[cr].length) {
						// 도착까지 가는경우
						cr = 8;
						cc = 1;
					}
					else if(cc == board[cr].length-1) {
						cr = 8;
						cc = 0;
					}
				}
			}
			
			// 방문처리
			if((cr == 8 && cc == 1) || visited[cr][cc] == 0) {
				// 도착점이거나, 방문이 안 되어 있으면
				visited[sr][sc] = 0;
				visited[cr][cc] = 1;
				y[i][0] = cr;
				y[i][1] = cc;
				
				game(cnt+1, y, s+board[cr][cc], visited);
				visited[sr][sc] = 1;
				visited[cr][cc] = 0;
				y[i][0] = sr;
				y[i][1] = sc;
			}
		}
	}
}
