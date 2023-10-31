def solution(n, wires): # 송전탑의 개수 n, 전선 정보 wires

    import copy
    min_cnt = 100000

    def find_set(x):  # 대표자 출력
        if parent[x] == x:
            return x
        parent[x] = find_set(parent[x])
        return parent[x]

    def union(x, y):  # 둘을 합침
        x = find_set(x)
        y = find_set(y)
        if x == y:
            return
        if x > y:
            parent[x] = y
        else:
            parent[y] = x

    for i in range(len(wires)):

        wires_2 = copy.deepcopy(wires)
        wires_2.pop(i)
        parent = [x for x in range(n)]

        for wire in wires_2:
            a, b = wire
            union(a-1,b-1)
        #### 첫 번째 예시에서 첫 번째 전선을 없앴을 때 parent가 [0,1,1,1,1,1,1,1,1] 이런식으로 나오는지 모를 일...
        res = set()
        for j in parent:
            if j != 0:
                res.add(j)

        if len(res) == 2:

            lst = []
            for r in res:
                lst.append(r)

            if min_cnt > abs(parent.count(lst[0])-parent.count(lst[1])):
                min_cnt = abs(parent.count(lst[0])-parent.count(lst[1]))

    return min_cnt