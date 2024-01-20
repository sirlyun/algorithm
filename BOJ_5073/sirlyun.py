'''
    Equilateral :  세 변의 길이가 모두 같은 경우
    Isosceles : 두 변의 길이만 같은 경우
    Scalene : 세 변의 길이가 모두 다른 경우
    Invalid : 삼각형 생성 불가한 경우 (가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.)
'''

while True:
    # 세 변
    triangle = list(map(int, input().split()))
    # 종료 조건
    if max(triangle) == 0:
        break
    triangle.sort()

    # 삼각형 가능성 검증
    if triangle[0]+triangle[1] <= triangle[2]:
        print('Invalid')
        continue
    else:
        cnt1 = triangle.count(triangle[0])
        cnt2 = triangle.count(triangle[1])
        cnt3 = triangle.count(triangle[2])
        cnt = max(cnt1, cnt2, cnt3)
        if cnt == 3:
            print('Equilateral')
            continue
        elif cnt == 2:
            print('Isosceles')
            continue
        else:
            print('Scalene')
            continue