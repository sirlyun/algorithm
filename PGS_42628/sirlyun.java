import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        int[] answer = new int[2];
        
        PriorityQueue<Integer> lowQueue = new PriorityQueue<>();
        PriorityQueue<Integer> highQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations){
            String[] chk = operation.split(" ");
        
            
            if(chk[0].equals("I")){
                lowQueue.add(Integer.valueOf(chk[1]));
                highQueue.add(Integer.valueOf(chk[1]));
            } else if(chk[0].equals("D")){
                if(lowQueue.size() < 1){
                    continue;
                }
                Integer tmp = Integer.valueOf(chk[1]);
                if(tmp > 0){
                    lowQueue.remove(highQueue.poll());
                } else{
                    highQueue.remove(lowQueue.poll());
                }
            }
        }
        
        if(lowQueue.size() > 0){
            answer[0] = highQueue.poll();
            answer[1] = lowQueue.poll();
        }
        
        return answer;
    }
}