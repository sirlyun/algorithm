'''
    a와 b로만 이루어진 문자열
    a를 모두 연속으로 만들어기 위해 필요한 최소 교환 횟수
    문자열은 원형의 형태다 
'''

ab_str = input()
cnt = 0
result = 1e9

for i in range(len(ab_str)):
    if ab_str[i] == 'a':
        cnt += 1

for i in range(len(ab_str)):
    chk_cnt = 0
    for j in range(i, i+cnt):
        if ab_str[j % len(ab_str)] == 'b':
            chk_cnt += 1
            
    result = min(result, chk_cnt)

print(result)