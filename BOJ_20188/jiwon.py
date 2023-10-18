N = int(input())
arr = [[] for _ in range(N+1)]
for _ in range(N-1):
    a, b = map(int,input().split())
    arr[a].append(b)  # 인접 리스트 생성
    arr[b].append(a)

d = [0] * (N+1)
res = 0
def dfs(me,parent):  # 현재/부모
    global res

    for child in arr[me]:
        if child != parent: 
            dfs(child,me)
            d[me] += d[child]+1

    val = (d[me] + 1) * (N - (d[me] + 1)) + (d[me] * (d[me] + 1) // 2)

    if me != 1:
       res += val

dfs(1,0)
print(res)