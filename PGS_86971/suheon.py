'''
갖고 있는 송전탑 개수 차이의 최소값
union find로 해봄
'''


def find_set(x, parents):
    if parents[x] == x:
        return x

    parents[x] = find_set(parents[x], parents)
    return parents[x]


def union(x, y, parents):
    x = find_set(x, parents)
    y = find_set(y, parents)

    if x == y:
        return

    if x < y:
        parents[y] = x
    else:
        parents[x] = y


def solution(n, wires):
    answer = 0
    min_v = int(1e9)
    wires.sort()
    # 어떤 거 제외하실?
    for i in range(len(wires)):
        parents = [0] + [i + 1 for i in range(n)]
        for j in range(len(wires)):
            if j == i:  # i번 째 wires 제외
                continue
            f = wires[j][0]
            t = wires[j][1]
            union(f, t, parents)

        # 두 개의 집합
        first = 0
        second = 0
        temp = 0
        for j in range(1,n+1):
            if temp == 0:
                temp = parents[j]
            if parents[j] == temp:
                first += 1
            else:
                second += 1

        # 차이?
        answer = abs(first - second)
        if min_v > answer:
            min_v = answer

    return min_v

n = 7
wires = [[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]

print(solution(n,wires))

