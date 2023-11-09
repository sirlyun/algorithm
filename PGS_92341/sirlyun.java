package algo_java.src;

/*
    주차 요금은 기본시간(분)/요금, 단위 시간(분)/요금
    입차 이후 출차 내역이 없으면 23:59에 출차한 것으로 간주
    초과한 기간이 단위 시간으로 나누어떨어지지 않으면 올림한다.
*/

import java.util.*;
import java.text.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, ArrayList<String>> recordMap = new HashMap<String, ArrayList<String>>();

        // 차량번호 key, 입/출 시간과 입/출 여부 value로 Map에 저장
        for (String record : records){
            String car = record.substring(6, 11);

            recordMap.put(car, new ArrayList());
        }
        for (String record : records){
            String time = record.substring(0, 6);
            String car = record.substring(6, 11);

            recordMap.get(car).add(time);
        }
        // 차량번호 오름차순으로 정렬
        List<String> keySet = new ArrayList<>(recordMap.keySet());
        Collections.sort(keySet);

        int[] answer = new int[keySet.size()];
        // answer index용 cnt
        int cnt = 0;
        // 차량번호별 탐색
        for(String key : keySet){
            ArrayList<String> chk = recordMap.get(key);
            // 누적시간 cost
            int cost = 0;
            // ParseException 예외 처리
            try{
                // SimpleDateFormat, Date 활용 시간 차이 계산
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                if (chk.size() % 2 == 0){
                    for (int i=0; i<chk.size(); i+=2){
                        String now = chk.get(i);
                        String next = chk.get(i+1);

                        Date nowDate = sdf.parse(now);
                        Date nextDate = sdf.parse(next);

                        long timeNow = nowDate.getTime();
                        long timeNext = nextDate.getTime();

                        long dif = timeNext - timeNow;

                        long difMin = dif / (1000 * 60);

                        // difMin 타입 변환
                        cost += Math.toIntExact(difMin);
                    }
                    // 누적시간이 기본시간을 초과하는지에 따라 계산
                    if (cost <= fees[0]){
                        answer[cnt] = fees[1];
                    } else{
                        double tmp = cost-fees[0];
                        answer[cnt] = fees[1] + (int)Math.ceil(tmp/fees[2])*fees[3];
                    }
                } else{
                    for (int i=0; i<chk.size()-1; i+=2){
                        String now = chk.get(i);
                        String next = chk.get(i+1);

                        Date nowDate = sdf.parse(now);
                        Date nextDate = sdf.parse(next);

                        long timeNow = nowDate.getTime();
                        long timeNext = nextDate.getTime();

                        long dif = timeNext - timeNow;

                        long difMin = dif / (1000 * 60);

                        cost += Math.toIntExact(difMin);
                    }
                    String last = chk.get(chk.size()-1);

                    Date lastDate = sdf.parse(last);
                    Date maxDate = sdf.parse("23:59");

                    long timeLast = lastDate.getTime();
                    long timeMax = maxDate.getTime();

                    long dif = timeMax - timeLast;

                    long difMin = dif / (1000 * 60);
                    // difMin 타입 변환
                    cost += Math.toIntExact(difMin);
                    // 누적시간이 기본시간을 초과하는지에 따라 계산
                    if (cost <= fees[0]){
                        answer[cnt] = fees[1];
                    } else{
                        double tmp = cost-fees[0];
                        answer[cnt] = fees[1] + (int)Math.ceil(tmp/fees[2])*fees[3];
                    }
                }
            }catch (ParseException e){
                e.printStackTrace();
            }
            cnt += 1;
        }


        return answer;
    }
}