'''
    N명의 사람들이 한 줄로 선다.
    사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만 기억한다.
    
    idx+1이 사람의 번호이자 키
    왼쪽부터 키 큰 사람이 쭉 있는게 아님
'''

N = int(input())
memory_list = list(map(int, input().split()))
result = [0]*N

for i in range(N):
    cnt = 0

    for j in range(N):
        if cnt == memory_list[i] and result[j] == 0:
            result[j] = i+1
            break
        elif result[j] == 0:
            cnt += 1
    
print(' '.join(map(str, result)))