import java.util.*;
import java.text.*;

class Solution {
    public int[] solution(int[] fees, String[] records) throws Exception {
        // 문자열로 주어진 시간을 계산하기 위해
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        // 트리맵 사용하기, 차량번호 작은 순 정렬 + 키, 밸류 형태로 값 꺼내기
        HashMap<String, String> hm = new HashMap<>();
        TreeMap<String, Integer> tm = new TreeMap<>();
        
        // records의 값 순회하며 트리맵에 추가
        for(int i = 0; i < records.length; i++) {
            // 해당 차량 번호가 트리맵에 포함되어 있으면
            if(hm.containsKey(records[i].substring(6, 10))) {
                // 비교할 시간 (문자열) 
                String timeStr1 = hm.get(records[i].substring(6, 10));
                String timeStr2 = records[i].substring(0, 5);

                // 문자열 -> Date 
                Date date1 = sdf.parse(timeStr1);
                Date date2 = sdf.parse(timeStr2);

                // Date -> 밀리세컨즈 
                long timeMil1 = date1.getTime();
                long timeMil2 = date2.getTime();

                // 비교 
                long diff = timeMil2 - timeMil1;
                long diffMin = diff / (1000 * 60);
                
                int min = (int)diffMin + tm.get(records[i].substring(6, 10));
                tm.put(records[i].substring(6, 10), min);
                hm.remove(records[i].substring(6, 10));
            }
            // 해당 차량 번호가 트리맵에 없으면
            else {
                if(!tm.containsKey(records[i].substring(6, 10))) {
                    tm.put(records[i].substring(6, 10), 0);
                }
                hm.put(records[i].substring(6, 10), records[i].substring(0, 5));
            }
            // System.out.println(hm);
        }
        
        // 순회가 끝나고 해쉬맵에 값이 남아있으면
        for(String s : hm.keySet()) {
            // 비교할 시간 (문자열) 
            String timeStr1 = hm.get(s);
            String timeStr2 = "23:59";

            // 문자열 -> Date 
            Date date1 = sdf.parse(timeStr1);
            Date date2 = sdf.parse(timeStr2);

            // Date -> 밀리세컨즈 
            long timeMil1 = date1.getTime();
            long timeMil2 = date2.getTime();

            // 비교 
            long diff = timeMil2 - timeMil1;
            long diffMin = diff / (1000 * 60);

            int min = (int)diffMin + tm.get(s);
            tm.put(s, min);
        }
        
        int[] answer = new int[tm.size()];
        // System.out.println(tm.size());
        int idx = 0;
        // 트리맵을 순회하며 시간당 주차 요금 계산
        for(String s : tm.keySet()) {
            int price = fees[1];
            if(tm.get(s) > fees[0]) {
                double time = (double)(tm.get(s)-fees[0]) / fees[2];
                price = price + (int)(Math.ceil(time) * fees[3]);
            }
            answer[idx] = price;
            // System.out.println(answer[idx]);
            idx++;
        }
        
        return answer;
    }
}