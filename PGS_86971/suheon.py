'''
갖고 있는 송전탑 개수 차이의 최소값
union find 가능?
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
    # 어떤 거 제외하실?
    for i in range(len(wires)):
        parents = [i for i in range(n+1)]
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
            # wires 배열 순서에 따라 부모 찾기가 잘 안되는 경우도 생겨서 다시 해줘야 함
            find_set(j,parents)
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