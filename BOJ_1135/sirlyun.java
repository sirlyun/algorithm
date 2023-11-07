package algo_java.src;

import java.io.*;
import java.util.*;

/*
    회사의 중요 뉴스를 전직원에게 빠르게 전달하려한다
    민식이의 회사는 트리 구조
    모든 직원은 정확하게 한명의 직속 상사가 있다.
    모든 직원은 민식이의 직간접적 부하이다
    민식이는 일단 자기 직속 부하에게 한번에 한명씩 연락을 한다
    뉴스를 들은 후에, 각 부하는 그의 직속 부하에게 한 번에 한 사람씩 전화를 한다.
    모든 직원이 뉴스를 들을 때 까지 계속된다.
    모든 사람은 직속 부하에게만 전화를 걸 수 있다
    전화는 정확하게 1분 걸린다
    모든 직원이 소식을 듣는데 걸리는 시간의 최솟값을 구하자
 */

public class Main {

    static int N;
    static int[] members;
    static List<ArrayList<Integer>> relation = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        members = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        // 0번 idx에 대한 값 버리기
        st.nextToken();
        relation.add(new ArrayList<>());
        // 트리 구조 저장
        for (int n=1; n<N; n++){
            relation.add(new ArrayList<>());
            int chk = Integer.parseInt(st.nextToken());
            relation.get(chk).add(n);
        }

        int result = dfs(0);
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();

    }

    static int dfs(int now){
        int cnt = 0;
        int maxCnt = 0;
        // cost가 높은 idx를 앞으로 땡겨오는 우선순위 큐
        Queue<Node> queue = new PriorityQueue<>();
        // 자식들 탐색
        for (Integer next : relation.get(now)){
            // 자식이 가지고 있는 자식들의 수 저장
            dp[next] += dfs(next);
            // 자식이 가지고 있는 자식들의 수를 cost로 한 체로 우선순위 큐에 추가
            queue.add(new Node(next, dp[next]));
        }

        // 깊이가 더 깊은 자식에 대해서 maxCnt 저장
        while (!queue.isEmpty()){
            Node node = queue.poll();
            cnt += 1;
            maxCnt = Math.max(maxCnt, node.cost+cnt);
        }

        return maxCnt;
    }
}

class Node implements Comparable<Node>{
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