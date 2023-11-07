'''
트리 구조
한 번에 한 사람씩 직속 부하에게 전화
모든 직원이 소식을 듣는데 걸리는 시간의 최솟값
부하 직원이 많은 쪽을 우선적으로 선택해야 한다. (X)
우선순위 큐 => BFS?

틀린이유 : 무지성으로 자식 수 많은 것만 선택했음
=> 제일 깊은 경로에서 올라오면서 연락 시간 최대값 => 최소값
'''

def dfs(s):
    cnt = 0
    max_cnt = 0
    if not arr[s]:
        return 0

    # 갈 수 있는 곳 돌기
    temp = [False] * len(arr[s])
    for i in range(len(arr[s])):
        temp[i] += dfs(arr[s][i])

    temp.sort(reverse=True) # 자식 수가 제일 많은 거 부터 해줘야 함

    for i in temp:
        cnt += 1
        max_cnt = max(max_cnt, cnt + i)

    return max_cnt

N = int(input())
x = list(map(int ,input().split()))

arr = [[] for _ in range(N)]

# 인접 리스트
for i in range(N):
    if i == 0:
        continue
    arr[x[i]].append(i)

# 자식 수 세기
print(dfs(0))