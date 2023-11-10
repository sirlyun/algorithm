'''
입차 후 출차내역 없음 -> 23:59에 출차된 것으로 간주
누적 주차 시간이 기본시간 이하 -> 기본요금
초과한 시간이 단위 시간으로 안나눠지면 올림-> "분" 단위!!

주차요금 fees(기본시간,기본요금,단위시간,단위요금)
입출차내역 records(시각,차량번호,내역)
차량번호가 "작은" 자동차부터 청구 금액 리턴
'''
import math

def solution(fees,records):

    garage = {} # 주차장
    fee = {}    # 요금
    times = {}  # 총 이용시간 누적합

    # 시간 누적합
    for record in records:
        info = list(record.split())
        if info[2] == "IN": # 들어옴! 시간 갱신
            garage[info[1]] = info[0]

        else: # 나감!
            hour = int(info[0][0:2]) - int((garage[info[1]])[0:2])
            if int(info[0][3:]) - int(garage[info[1]][3:]) < 0:
                hour -= 1
                minute = 60 - (int(garage[info[1]][3:]) - int(info[0][3:]))
            else:
                minute = int(info[0][3:]) - int(garage[info[1]][3:])
            total_time = hour * 60 + minute

            if info[1] in times.keys(): # 2회차면 누적
                times[info[1]] += total_time
            else:                       # 1회차면 생성
                times[info[1]] = total_time

            garage[info[1]] = 0  # 나간거 표시

    # 입차 후 출차내역 없음 -> 23:59에 출차된 것으로 간주
    for g in garage.keys():
        if garage.get(g) != 0:

            hour = 23 - int(garage.get(g)[0:2])
            minute = 59 - int(garage.get(g)[3:])
            total_time = hour * 60 + minute

            if g in times.keys():
                times[g] += total_time
            else:
                times[g] = total_time

    # 요금계산
    for time in times.keys():
        if times[time] <= fees[0]: # 기본요금이면
            fee[time] = fees[1]
        else:                      # 초과요금
            fee[time] = fees[1] + (math.ceil((times[time] - fees[0]) / fees[2])) * fees[3]

    ans = []
    fin = sorted(fee)
    for f in fin:
        ans.append(fee[f])
    return ans



