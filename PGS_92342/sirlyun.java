package algo_java.src;

/*
    1. 어피치가 화살 n발을 다 쏜 후에 라이언이 화살 n발을 쏜다.
    2. 점수 계산
        만약 k(1<=k<=10)점을 어피치가 a발을 맞추고, 라이언이 b발을 맞추면
        더 많은 화살을 k점에 맞힌 선수가 k점을 가진다.
        단, a = b 일 경우 어피치가 k점을 가져간다.
        a = b = 0 이면 누구도 점수를 갖지 못한다.
        모든 과녁 점수에 대하여 각 선수의 최종 점수를 계산한다.
    3. 최종 점수가 더 높은 선수를 우승자로 결정, 같으면 어피치가 우승

    어피치가 화살을 다 쏜 후, 라이언이 화살을 쏠 차례
    라이언이 어피치를 가장 큰 점수 차로 이기기 위해 n발의 화살을 어떤 점수에 맞춰야 할까

    무조건 라이언이 우승을 못하는 경우에는 [-1]을 반환
    라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우,
    가장 낮은 점수를 더 많이 맞힌 경우를 반환

    모든 과녁에서 이기는 경우를 다 탐색해서 최댓값을 찾아야함
*/

class Solution {
    static int[] lionScore = new int[11];
    static int chk = Integer.MIN_VALUE;
    static int[] result = {};

    public int[] solution(int n, int[] info) {
        dfs(0, n, info);

        if (chk == -1){
            result = new int[1];
            result[0] = -1;
        }
        return result;
    }

    static void dfs(int depth, int n, int[] info){

        if (depth == n){
            int tmp = checkScore(info);

            if (chk <= tmp){
                chk = tmp;
                result = lionScore.clone();
            }
            return;
        }

        for (int i = 0; i < info.length && lionScore[i] <= info[i]; i++) {
            lionScore[i] += 1;
            dfs(depth + 1, n, info);
            lionScore[i] -= 1;
        }
    }

    static int checkScore(int[] info){
        int apeach = 0;
        int lion = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0 && lionScore[i] == 0){
                continue;
            }
            if (info[i] >= lionScore[i]){
                apeach += (10 - i);
            }
            else {
                lion += (10 - i);
            }
        }

        int tmp = lion - apeach;

        if (tmp <= 0) {
            return -1;
        }
        return tmp;
    }
}