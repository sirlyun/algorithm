def solution(fees, records):
    answer = []
    dic_fee = dict()
    dic_time = dict()
    # fees 각각 저장
    dft_time, dft_fee, unit_time, unit_fee = fees[0], fees[1], fees[2], fees[3]
    
    # list 형식으로 바꾸기, 시간을 int, 분 단위로 바꾸기
    records = list(map(lambda x:list(x.split(' ')), records))
    for i in range(len(records)):
        hours, minutes = records[i][0].split(':')
        records[i][0] = int(hours)*60 + int(minutes)
        dic_fee[records[i][1]] = 0
        dic_time[records[i][1]] = 0

    # 누적 시간 계산
    for info in records:
        time, car_num, IN_or_OUT = info[0], info[1], info[2]
        if IN_or_OUT == 'IN':
            dic_time[car_num] = time + 1
        elif IN_or_OUT == 'OUT':
            dic_fee[car_num] += time - dic_time[car_num] + 1
            dic_time[car_num] = 0
    
    # 출차 안한 차량 체크
    for key, value in dic_time.items():
        if value != 0:
            dic_fee[key] += (59 + 23*60) - value + 1
    
    # 누적 시간을 차량 번호 순으로 정렬
    answer = [i[1] for i in sorted(list(dic_fee.items()))]
    
    # 조건에 따라 금액 계산
    for i in range(len(answer)):
        if answer[i] <= dft_time:
            answer[i] = dft_fee
        else:
            time = answer[i] - dft_time
            if time % unit_time == 0:
                answer[i] = dft_fee + (time//unit_time)*unit_fee
            else:
                answer[i] = dft_fee + (time//unit_time + 1)*unit_fee
        
    return answer