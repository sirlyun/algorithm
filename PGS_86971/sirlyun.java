package algo_java.src;

import java.io.*;
import java.util.*;

/*
    n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있다.
    이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려 한다.
    이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {

        int n = 4;
        int[][] wires = {{1,2}, {2, 3}, {3, 4}};

        System.out.println("answer = " + solution(n, wires));;

    }

    static int solution(int n, int[][] wires) {
        int answer = 100;


        for (int i=0; i<n-1; i++){
            int[][] chk = new int[n-1][2];
            for (int j=0; j<n-1; j++){
                if (i == j){
                    continue;
                }
                chk[j] = wires[j];
            }
            int cnt = bfs(chk, n);
            answer = Math.min(answer, cnt);
        }



        return answer;
    }

    static int bfs(int[][] chk, int n){

        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<n-1; i++){
            graph.get(chk[i][0]).add(chk[i][1]);
            graph.get(chk[i][1]).add(chk[i][0]);
        }

        int[] check = new int[n+1];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = 1;
        while (!queue.isEmpty()){
            int now = queue.poll();

            for (int next : graph.get(now)){
                if (check[next] != 1){
                    check[next] = 1;
                    cnt += 1;
                    queue.add(next);
                }
            }
        }


        return Math.abs(n-2*cnt);
    }

}

