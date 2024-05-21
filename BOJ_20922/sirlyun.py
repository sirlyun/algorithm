'''
    수열에서 같은 원소가 여러 개 들어있으면 안되는 병
    같은 원소가 K개 이하로 들어있는 최장 연속 부분 수열의 길이 구하기
'''

N, K = map(int, input().split())
num_list = list(map(int, input().split()))

check = [0]*100001
l, r = 0, 0
result = 0
cnt = 0
while l < N and r < N:
    # 넣을 수 있는지 체크
    if check[num_list[r]] + 1 <= K:
        check[num_list[r]] += 1
        r += 1
        cnt += 1
    else:
        check[num_list[l]] -= 1
        l += 1
        cnt -= 1

    result = max(result, cnt)

print(result)