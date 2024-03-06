'''
    k개의 문제를 풀고, 각 문제 당 0~100점 사이의 점수를 얻는다.
    풀이를 제출한 팀 ID, 문제 번호, 점수가 입력으로 주어진다.

    한 문제에 대해 여러 번 답을 제출할 수 있고,
    최고 점수가 해당 문제의 최종 점수가 된다.

    팀의 최종 점수는 각 문제의 점수 총합이다.
    순위는 (본인 팀보다 높은 점수를 받은 팀의 수) + 1이다.

    동일 점수가 여럿인 경우
        1. 풀이 제출 횟수가 적은 팀의 순위가 더 높다.
        2. 마지막 제출 시간이 더 빠른 팀의 순위가 더 높다.
'''

import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    team_total, q_total, my_team, log_total = map(int, input().split())
    teams = {}
    for i in range(team_total):
        # 팀 별: 문제 별 점수 모음, 제출 횟수, 마지막 제출 시간 저장
        teams[i+1] = [[0] * (q_total + 1), 0, 0]
    for i in range(log_total):
        team, q_num, score = map(int, input().split())
        teams[team][0][q_num] = max(teams[team][0][q_num], score)
        teams[team][1] += 1
        teams[team][2] = i
    
    result = 1
    my_score = sum(teams[my_team][0])
    for key in teams.keys():
        if key != my_team:
            chk_score = sum(teams[key][0])
            if chk_score > my_score:
                result += 1
            elif chk_score == my_score:
                if teams[my_team][1] > teams[key][1]:
                    result += 1
                elif teams[my_team][1] == teams[key][1]:
                    if teams[my_team][2] > teams[key][2]:
                        result += 1
    
    print(result)