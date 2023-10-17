'''
진실 ->
'''

N, M = map(int ,input().split()) # 사람 수, 파티의 수

# 진실을 아는 사람의 수와 번호
know_true = list(map(int, input().split()))
# 각 파티마다 오는 사람의 수와 번호
party = []
for _ in range(M):
    arr = list(map(int, input().split()))
    party.append(arr)


