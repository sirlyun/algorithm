package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13549 {
	// 전역변수
	static int N;	// 수빈이 위치
	static int K;	// 동생 위치
	static int[] count = new int[100001];	// 각 위치까지 걸리는 시간

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 수빈이와 동생의 위치 받기
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// count 배열 최고값 갱신
		for (int i = 0; i < 100001; i++) {
			count[i] = 100002;
		}
		
		int time = bfs(N);
		
		System.out.println(time);
	}

	static int bfs(int n) {
		// 큐 선언
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		count[n] = 0;
		
		// bfs 반복
		while(q.size() > 0) {
			int pos = q.poll();		// 현재 위치
			
			// x-1로 이동할 때
			if((pos-1) >= 0) {
				if(count[pos-1] > (count[pos]+1)) {
					count[pos-1] = count[pos] + 1;
					q.add(pos-1);
				}
			}
			
			// x+1로 이동할 때
			if((pos+1) <= 100000) {
				if(count[pos+1] > (count[pos]+1)) {
					count[pos+1] = count[pos] + 1;
					q.add(pos+1);
				}
			}
			
			// 순간이동할 때
			if((pos*2) <= 100000) {
				if(count[pos*2] > count[pos]) {
					count[pos*2] = count[pos];
					q.add(pos*2);
				}
			}
		}
		
		return count[K];
	}
}
