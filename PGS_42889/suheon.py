'''
stages 순회
1. fail[요소] += 1
2. clear[1~[요소-1]] += 1
스테이지 개수 순회
1. 실패율 계산
2. rr[요소-1][0]에 넣기
3. sort() => 정렬이 힘들엉

# 런타임 에러 70.4 / 100.0
# 아래 질문과 같이 1,6,7,9,13,23,24,25 틀림  => zerodivision error
# 반례입니다.
# 입력값 〉 2, [1, 1, 1, 1]
# 기댓값 〉 [1, 2]
# https://school.programmers.co.kr/questions/49959

# 시간 초과
# append쓰지말기

'''

N = 5 # 스테이지의 개수
stages = [2, 1, 2, 6, 2, 4, 3, 3] # 사용자들이 도전 중인 스테이지

# (0~N+1)
fail = [0] * (N+1)
clear = [0] * (N+1)
rr = [[0,i] for i in range(1,N+1)] # 실패율

# stages 순회
for i in stages:
    fail[i-1] += 1
    for j in range(i):
        clear[j] += 1

# 스테이지 개수(N) 순회
for i in range(N):
    # if fail == 0:
    if fail[i] == 0 or clear[i] == 0: ##### 실패 후 이 부분 수정
        continue
    x = float(fail[i]) / float(clear[i])
    rr[i][0] = x


rr.sort(key=lambda x:(-x[0], x[1])) # 내림차순

result = [0] * N

for i in range(N):
    result[i] = rr[i][1]

print(result)