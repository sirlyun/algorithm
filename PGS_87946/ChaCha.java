class Solution {
    private static int[] arr;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        // 하루에 한번 탐험할 수 있는 던전이 여러개
        // 최대한 많이 탐험
        
        // 유저의 현재 피로도 k
        // 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons
        
        // 유저가 탐험할수 있는 최대 던전 수
        
        
        // 순열
        // 0, 1, 2
        
        arr = new int[dungeons.length];
        
        for (int i = 0; i < dungeons.length; i++) {
            arr[i] = i;
        }
        
        do {
            // 계산
            int result = available(k, dungeons);
            
            answer = Math.max(result, answer);
        } 
        while (nextPermutation());
        
        return answer;
    }
    
    private static int available(int k, int[][] dungeons) {
        int count = 0;
        int hp = k;
        
        for (int i = 0; i < arr.length; i++) {
            int min = dungeons[arr[i]][0];
            int nec = dungeons[arr[i]][1];
            
            if (hp >= min) {
                count += 1;
                hp -= nec;
            }
        }
        
        return count;
    }
    
    private static boolean nextPermutation() {
        // 꼭대기 index
        int topIndex = arr.length - 1;

        // 오른쪽부터 왼쪽으로 탐색하며, 가장 왼쪽 꼭대기를 찾는다.
        while (topIndex >= 1 && arr[topIndex - 1] >= arr[topIndex]) {
            topIndex -= 1;
        }

        // 꼭대기가 없다면, 마지막 순열이다.
        if (topIndex <= 0) {
            return false;
        }

        // 꼭대기를 제외한 나머지 부분 중, 꼭대기 바로 왼쪽 값보다 큰 값 중 가장 작은 값을 찾는다.
        int j = arr.length - 1;
        while (arr[j] <= arr[topIndex - 1]) {
            j -= 1;
        }

        // 찾은 값을 꼭대기 바로 왼쪽 값과 swap 한다.
        swap(topIndex - 1, j);

        // 꼭대기를 제외한 나머지 부분을 오름차순으로 정렬한다.
        j = arr.length - 1;
        while (topIndex < j) {
            swap(topIndex, j);
            topIndex += 1;
            j -= 1;
        }

        return true;
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
