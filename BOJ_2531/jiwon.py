
n, d, k, c = map(int, input().split()) # 접시수/초밥가짓수/연속해서먹는접시수/쿠폰번호
arr = []
ans = 0
for _ in range(n):
    num = int(input())
    arr.append(num)

for i in range(n):
        if i+k > n:  # 한바퀴 돌아?
            check = len(set(arr[i:n] + arr[:(i+k)%n] + [c]))
        else:
            check = len(set(arr[i:i+k]+[c]))
        if ans < check:
            ans = check
print(ans)

