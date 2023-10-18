import sys
sys.stdin = open("input.txt")
# 피보나치 9711

T = int(input())
for tc in range(1, T+1):
    P, Q = map(int, input().split())
    numbers = [1]*P
    for i in range(2, P):
        numbers[i] = numbers[i-2] + numbers[i-1]
    M = numbers[P-1] % Q
    # print(numbers)
    print(f'Case #{tc}: {M}')
