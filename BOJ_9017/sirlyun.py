'''
    한 팀은 여섯명의 선수로 구성
    팀 점수는 상위 네명의 선수 점수를 합하여 계산
    결승점을 통과한 순서대로 점수를 준다
    팀 점수가 가장 낮은 팀이 우승
    여섯명의 주자가 참가하지 못한 팀은 점수 계산에서 제외
    동점의 경우 다섯번째 주자가 가장 빨리 들어온 팀이 우승
'''

T = int(input())
for _ in range(T):
    N = int(input())
    # 팀 번호가 입력됨, 순서는 들어온 순서
    run_result = list(map(int, input().split()))

    # 인원이 여섯명인 팀만 살리기
    new_result = []
    for i in range(N):
        if run_result.count(run_result[i]) == 6:
            new_result.append(run_result[i])
    # 팀당 등 수 저장
    team_dict = {}
    for i in range(len(new_result)):
        team_dict.setdefault(new_result[i], []).append(i+1)
    # 팀 점수와 5번째로 들어온 멤버의 등 수 저장
    chk_dict = {}
    for key in team_dict.keys():
        team_score = sum(team_dict[key][:4])
        five_member = team_dict[key][4]
        chk_dict.setdefault(key, []).append(team_score)
        chk_dict[key].append(five_member)
    
    # 팀 점수 체크 및 같으면 5번째 멤버 체크
    winner = 0
    min_score = 1e9
    cnt = 0
    min_five = 1e9
    five_winner = 0
    for key in team_dict.keys():
        if min_score > chk_dict[key][0]:
            winner = key
            min_score = chk_dict[key][0]
            cnt = 1
            if min_five > chk_dict[key][1]:
                five_winner = key
                min_five = chk_dict[key][1]
        elif min_score == chk_dict[key][0]:
            cnt += 1
            if min_five > chk_dict[key][1]:
                five_winner = key
                min_five = chk_dict[key][1]

    if cnt == 1:
        print(winner)
    else:
        print(five_winner)