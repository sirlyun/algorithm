'''
    NxN 크기의 격자
    격자를 다섯개의 선거구로 나누고 모든 격자는 특정 선거구에 포함되고 한개의 격자도 포함 못하는 선거구는 없다
    한 선거구 내에 있는 격자들은 모두 연결되어 있어야 한다.
    구역 A에서 인접한 구역을 통해서 구역 B로 갈 수 있을 때, 두 구역은 연결되어 있다고 한다
    중간에 통해서 가는 구역 또한 같은 선거구에 있어야한다.

    선거구 나누는 방법
        기준점 (x, y)와 경계의 길이 d1, d2를 정한다. (d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N)
        다음 칸은 경계선이다.
        (x, y), (x+1, y-1), ..., (x+d1, y-d1)
        (x, y), (x+1, y+1), ..., (x+d2, y+d2)
        (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
        (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
        경계선과 경계선의 안에 포함되어있는 곳은 5번 선거구이다.
        5번 선거구에 포함되지 않은 구역 (r, c)의 선거구 번호는 다음 기준을 따른다.
        1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
        2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
        3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
        4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
'''

def cal(x, y, d1, d2):
    global result, total
    one, two, three, four = 0, 0, 0, 0

    # 1구역
    col1 = y+1
    for r in range(x+d1):
        if r >= x:
            col1 -= 1
        one += sum(area_list[r][:col1])

    # 2구역
    col2 = y+1
    for r in range(x+d2+1):
        if r > x:
            col2 += 1
        two += sum(area_list[r][col2:])
   
    # 3구역
    col3 = y - d1
    for r in range(x+d1, N):
        three += sum(area_list[r][:col3])
        if r < x+d1+d2:
            col3 += 1

    # 4구역
    col4 = (y+d2) - N
    for r in range(x+d2+1, N):
        four += sum(area_list[r][col4:])
        if r <= x+d1+d2:
            col4 -= 1

    # 5구역        
    five = total - one - two - three - four
    result = min(result, (max(one, two, three, four, five) - min(one, two, three, four, five)))

def check(x, y, d1, d2):
    # 유효한 경우에만 계산
    if 0 <= x+d1-1 < N and 0 <= x+d2-1 < N and 0 <= y-d1+d2-1 < N:
        if 0 <= y-d1 and y+d2 < N and x+d1+d2 < N:
            cal(x, y, d1, d2)


N = int(input())
area_list = [list(map(int, input().split())) for _ in range(N)]

# 초기 전체 인구 저장
total = 0
for row in area_list:
    total += sum(row)
result = 1e9

# x와 y가 가능한 범위 내에서 체크
for i in range(N-2):
    for j in range(1, N-1):
        # d1과 d2가 가능한 범위 내에서 체크
        for d1 in range(1, N-1):
            for d2 in range(1, N-1):
                check(i, j, d1, d2)

print(result)