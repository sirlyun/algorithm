'''
    최소한의 객실만 사용하여 예약 손님 받기
    한 번 사용하면 퇴실 시간 기준 10분 청소 후 다른 사람 사용 가능
'''

import heapq

def solution(book_time):
    answer = 1
    
    book_list = []
    for start, end in book_time:
        tmp = []
        # 입실
        tmp.append(int(start[:2])*60+int(start[3:]))
        # 퇴실
        tmp.append(int(end[:2])*60+int(end[3:]))
        book_list.append(tmp)
    book_list.sort()
    # 입실 시키기
    result = []
    for start, end in book_list:
        if not result:
            heapq.heappush(result, end)
            continue
        if result[0]+10 <= start:
            heapq.heappop(result)
        else:
            answer += 1
            
        heapq.heappush(result, end)
    
    return answer