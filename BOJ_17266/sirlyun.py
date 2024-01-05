def check(tmp):
    chk = 0
    for loc in location:
        if loc - tmp <= chk:
            chk = loc + tmp
        else:
            return False

    return location[-1] + tmp >= N

N = int(input())
M = int(input())
location = list(map(int, input().split()))

left = 1
right = N
result = 0

while left <= right:
    mid = (left + right) // 2

    if check(mid):
        result = mid
        right = mid - 1
    else:
        left = mid + 1

print(result)