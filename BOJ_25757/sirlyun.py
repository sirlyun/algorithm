'''
    윷놀이 Y (2명), 같은 그림 찾기 F(3명), 원카드 O(4명)
    플레이 신청 횟수 N, 플레이 할 게임의 종류가 주어진다
    최대 몇번 함께 게임할 수 있는가
    한 번 같이 플레이한 사람과는 다시 게임하지 않는다
'''

N, game = input().split()
# 게임에 필요한 인원 수(주인공 제외)
if game == 'Y':
    need = 1
elif game == 'F':
    need = 2
elif game == 'O':
    need = 3

# 모든 게임 신청자는 신청 횟수 상관없이 한 번만 게임 가능
players = set()
for n in range(int(N)):
    players.add(input())

print(len(players)//need)