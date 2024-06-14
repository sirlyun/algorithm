'''
    게임 방식
        1. 알파벳 소문자로 이루어진 문자열 W
        2. 양의 정수 K
        3. 어떤 문자를 K개 포함하는 가장 짧은 연속 문자열의 길이 구하기
        4. 어떤 문자를 K개 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자와 같은 가장 긴 연속 문자열의 길이 구하기
'''

T = int(input())
for t in range(T):
    W = input()
    K = int(input())

    W_dict = {}
    W_idx_dict = {}
    for w in range(len(W)):
        W_dict.setdefault(W[w], 0)
        W_dict[W[w]] += 1
        W_idx_dict.setdefault(W[w], [])
        W_idx_dict[W[w]].append(w)

    result_three = 1e9
    result_four = 0

    for w in W:
        if W_dict[w] < K:
            continue
        
        for i in range(len(W_idx_dict[w])-K+1):
            check = W_idx_dict[w][i+K-1] - W_idx_dict[w][i] + 1
            result_three = min(result_three, check)
            result_four = max(result_four, check)

    if result_three == 1e9 and result_four == 0:
        print(-1)
    else:
        print(f'{result_three} {result_four}')