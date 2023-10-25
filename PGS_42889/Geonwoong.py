def solution(N, stages):
    answer = []
    ans = []

    lst = [0] * (N+2)
    
    for num in stages:
        lst[num] += 1
    
    lst_pass = lst.copy() 
    lst_pass = lst_pass[1:]

    for i in range(len(lst_pass) - 1, 0, -1):
        lst_pass[i-1] += lst_pass[i]
    lst_pass = [0] + lst_pass
    
    for i in range(1, N+1):
        if lst_pass[i] == 0:
            answer.append([0, N - i])
        else:
            answer.append([lst[i]/lst_pass[i], N - i])
    
    answer.sort(key = lambda x: (x[0], x[1]), reverse = True)
    for i in range(len(answer)):
        ans.append(-(answer[i][1]-N))
        
    
    return ans