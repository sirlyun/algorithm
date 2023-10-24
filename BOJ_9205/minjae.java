package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 한글 나오나?
public class boj_9205 {
	// 전역 변수
	static int[] home;	// 상근이 집 좌표
	static int[][] mart;	// 편의점 좌표
	static int[] festival;	// 축제 좌표
	static int[] visited;	// 방문처리용 배열
	static Queue<Integer> q = new LinkedList<>();	// 큐

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());	// 편의점 갯수
			
			// 집 좌표 입력
			home = new int[2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			// 편의점 좌표 입력
			mart = new int[n][2];
			visited = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				mart[i][0] = Integer.parseInt(st.nextToken());
				mart[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 축제 좌표 입력
			festival = new int[2];
			st = new StringTokenizer(br.readLine());
			festival[0] = Integer.parseInt(st.nextToken());
			festival[1] = Integer.parseInt(st.nextToken());
			
			boolean result = bfs(home[0], home[1]);
			
			// 결과값이 true면 happy, false면 sad 출력
			if(result) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			// 제출 결과 ArrayIndexOutOfBounds 에러 발생
			
		}// tc for
	}
	
	static boolean bfs(int r, int c) {
		// 현재 좌표
		int row = r;
		int col = c;
		
		if(Math.abs(festival[0]-row) + Math.abs(festival[1]-col) <= 1000) {
			// 현재 위치와 축제 위치가 1000m 이내라면
			return true;
		}
		else {
			// 현재 위치와 축제 위치가 1000m 넘게 차이나면
			for (int i = 0; i < mart.length; i++) {
				// 편의점을 찾아간다
				if(visited[i] == 0 && (Math.abs(mart[i][0]-row) + Math.abs(mart[i][1]-col)) <= 1000) {
					// 아직 방문하지 않았고, 현재 위치와의 차이가 1000 이내인 편의점이라면
					q.add(i);	// 해당 편의점 방문
					visited[i] = 1;
				}
			}
		}
		
		while(q.size() > 0) {
			int idx = q.poll();		// 방문한 편의점 인덱스
			if(Math.abs(festival[0]-mart[idx][0]) + Math.abs(festival[1]-mart[idx][1]) <= 1000) {
				// 현재 위치와 축제 위치가 1000m 이내라면
				return true;
			}
			else {
				// 현재 위치와 축제 위치가 1000m 넘게 차이나면
				for (int i = 0; i < mart.length; i++) {
					// 편의점을 찾아간다
					if(visited[i] == 0 && (Math.abs(mart[i][0]-mart[idx][0]) + Math.abs(mart[i][1]-mart[idx][1])) <= 1000) {
						// 아직 방문하지 않았고, 현재 위치와의 차이가 1000 이내인 편의점이라면
						q.add(i);	// 해당 편의점 방문
						visited[i] = 1;
					}
				}
			}
		}
		return false;
	}

}
