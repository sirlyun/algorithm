'''
어떤 점수를 가져갈건지 1개부터 최대 n개까지
11Cr
경우의 수 중에
1. 합이 5를 넘으면 안된다.
2. 라이언을 이겨야 된다.
3. 최대 점수, 그 때의 배열 저장
4. 배열 비교


이게 왜 됨??????
'''

c = [0] * 11
max_score = 0
max_array = [0] * 11
can_win = 0


def comb(x, r, n, info):  # n은 쏘는 화살 개수
    global max_score
    global can_win
    global max_array

    if sum(c) > n:
        return
    if r == 0:
        # 점수 비교
        l = 0  # 라이언
        p = 0  # 어피치

        for i in range(11):
            if c[i] == 0 and info[i] == 0:
                continue
            if c[i] > info[i]:
                l += 10 - i
            else:
                p += 10 - i

        if l > p:
            can_win = 1
            # 최대 차이가 아니면 return
            if l - p < max_score:
                return
            elif l - p == max_score:  # 같을 때는 배열 비교
                # if sum(c) != n:     # 배열 채우기
                #     c[10] += n-sum(c)

                for i in range(10, -1, -1):
                    if max_array[i] == c[i]:
                        continue
                    if max_array[i] > c[i]:
                        break
                    else:
                        max_array = c[:]
                        break
            else:
                max_score = l - p

                # if sum(c) != n:     # 배열 채우기
                #     c[10] += n-sum(c)

                max_array = c[:]
        else:
            return

    elif x < r:
        return
    else:
        c[x - 1] = info[x - 1] + 1
        comb(x - 1, r - 1, n, info)  # 선택
        c[x - 1] = 0
        comb(x - 1, r, n, info)  # 안 선택


def solution(n, info):
    answer = [-1]

    for i in range(1, n + 1):
        comb(11, i, n, info)

    if sum(max_array) != n:  # 배열 채우기
        max_array[10] = n - sum(max_array)

    if can_win:
        return max_array
    else:
        return answer
