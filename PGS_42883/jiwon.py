# 테케 4개만 맞음
def solution(number,k):
    ans = []
    num = []
    for i in number:
        num.append(int(i))
    long = len(num) - k
    i = 0
    while long > 0:
        if long == len(num[i:]):
            ans.append(num[i])
            long -= 1
            i += 1

        if i == i + long - 1 or i == i + long - 2:
            ans.append(max(num[i:i + long + 1]))
            i += num[i:i + long + 1].index(max(num[i:i + long + 1])) + 1
            long -= 1
        else:
            ans.append(max(num[i:i + long - 1]))
            i += num[i:i + long - 1].index(max(num[i:i + long - 1])) + 1
            long -= 1
    answer = "".join(map(str, ans))
    return answer
