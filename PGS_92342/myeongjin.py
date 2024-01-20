import copy

max_diff = 0
answer = []
ans = []

def dfs(start, info, answer, n):
    global max_diff, ans
    
    if start == 11:
        Lscore = 0
        Ascore = 0
        
        for i in range(11):
            if answer[i] > info[i]:
                Lscore += 10 - i
            
            elif answer[i] == 0 and info[i] == 0:
                continue
            
            else: 
                Ascore += 10 - i
        diff = Lscore - Ascore
        if diff <= 0:
            return
        
        if max_diff <= diff:
            max_diff = diff
            ans = copy.deepcopy(answer)

            return
        
        return
    
    if info[start] < n:
        answer.append(info[start]+1)
        dfs(start+1, info, answer, n-(info[start]+1))
        answer.pop()
    
    answer.append(0)
    dfs(start+1, info, answer, n)
    answer.pop()


def solution(n, info):
    global answer
    start = 0

    dfs(start, info, answer, n)
    
    if not ans:
        return [-1]

    return ans

n = 10
info = [0,0,0,0,0,0,0,0,3,4,3]
solution(n, info)

# import copy

# maxScoreDiff = 0
# answer = []


# def calc_score_diff(ryans, apeachs):
#     ryan = 0
#     apeach = 0

#     for i in range(10):
#         if (ryans[i], apeachs[i]) == (0, 0):
#             continue
#         if ryans[i] > apeachs[i]:
#             ryan += 10 - i
#         else:
#             apeach += 10 - i

#     return ryan - apeach


# def dfs(info, shots, n, i):
#     global maxScoreDiff, answer
#     if i == 11:
#         score_diff = calc_score_diff(shots, info)
#         if score_diff <= 0:
#             return
#         res = copy.deepcopy(shots)
#         if maxScoreDiff < score_diff:
#             maxScoreDiff = score_diff
#             answer = [res]
#             return
#         if maxScoreDiff == score_diff:
#             answer.append(res)
#         return

#     if info[i] < n:
#         shots.append(info[i] + 1)
#         dfs(info, shots, n - info[i] - 1, i + 1)
#         shots.pop()

#     shots.append(0)
#     dfs(info, shots, n, i + 1)
#     shots.pop()


# def solution(n, info):
#     global answer

#     dfs(info, [], n, 0)

#     if not answer:
#         return [-1]

#     answer.sort(key=lambda x: x[::-1], reverse=True)

#     return answer[0]