'''
    꼭대기에서 바닥으로 이어지는 경로 중,
    거쳐간 숫자의 합이 가장 큰 경우를 찾자
    아래 칸으로 이동 시 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능
    삼각형의 정보가 담긴 배열이 주어질 때 거쳐간 숫자의 최댓값을 반환
'''

def solution(triangle):
    # triangle 자체를 dp 배열로 활용
    for i in range(1, len(triangle)):
        for j in range(i+1):
            
            # i층에서 맨앞에 있는 숫자의 경우
            # 전층의 맨앞에 있는 숫자를 선택해야만 가능
            if j==0:
                triangle[i][j] += triangle[i-1][j]
                
            # i층에서 맨뒤에 있는 숫자의 경우
            # 전층의 맨뒤에 있는 숫자를 선택해야만 가능
            elif j==i:
                triangle[i][j] += triangle[i-1][j-1]
                
            # 이외에는 최댓값 비교 후 선택
            else:
                triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
    
    # 마지막 행에서 최댓값 찾기
    return max(triangle[-1])