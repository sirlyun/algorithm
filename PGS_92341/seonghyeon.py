import math

def solution(fees, records):
    
    basic_time = fees[0]
    basic_fee = fees[1]
    part_time = fees[2]
    part_fee = fees[3]
    
    cars = {}
    
    for record in records :
        
        hour = int(record[0:2])
        minute = int(record[3:5])
        car_num = record[6:10]
        isIn = record[11:13]
        
        if car_num not in cars.keys() :
            
            cars[car_num] = []
            
        cars[car_num].append(hour * 60 + minute)

    time_cars = []
            
    for i in cars.keys() :
        
        if len(cars[i]) % 2 != 0 :
            
            cars[i].append(23 * 60 + 59)
            
        time = 0
            
        for j in range(0,len(cars[i]),2) :
                
            time += cars[i][j+1] - cars[i][j]
            
        time_cars.append((int(i),time))
        
    time_cars.sort()
    
    answer = []
    
    for i in time_cars :
        
        if i[1] <= basic_time :
            
            answer.append(basic_fee)
            
        else :
        
            answer.append(basic_fee + math.ceil((i[1] - basic_time)/part_time) * part_fee)
    
    return answer