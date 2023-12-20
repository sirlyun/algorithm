'''
    키 순으로 번호 부여
    총 20명
    같은 키를 가진 사람 없음

    특별한 방법
        아무나 한명을 뽑아 맨 앞에 세우기
        이후
            자기 앞에 자기보다 키가 큰 학생이 없으면 그냥 거기 서있기
            자기보다 키 큰 학생이 한명 이상 있으면 그 중 가장 앞에 있는 학생 앞에 서기
    
            학생들이 총 몇번 뒤로 물러설까
'''

P = int(input())

for p in range(P):
    tmp = list(map(int, input().split()))
    T = tmp[0]
    mils = tmp[1:]
    result = 0
   
    for i in range(19):
        for j in range(i+1, 20):
            if mils[i] > mils[j]:
                mils[i], mils[j] = mils[j], mils[i]
                result += 1
    
    print(f'{T} {result}')