'''
    이야기할 때 되도록 과장해서 말하고싶지만 웬만하면 거짓말쟁이가 들통나지 않을 정도만
    여기서 문제는 몇몇 사람들이 이야기의 진실을 알고 있다는 것
    이런 사람들이 파티에 왔을 때는, 지민이는 진실을 이야기할 수 밖에 없다. 
    당연히, 어떤 사람이 어떤 파티에서는 진실을 듣고, 또다른 파티에서는 과장된 이야기를 들었을 때도 지민이는 거짓말쟁이로 알려지게 된다.
    사람의 수 N이 주어진다. 그리고 그 이야기의 진실을 아는 사람이 주어진다. 
    각 파티에 오는 사람들의 번호가 주어진다. 
    지민이는 모든 파티에 참가해야 한다. 
    이때, 지민이가 거짓말쟁이로 알려지지 않으면서, 과장된 이야기를 할 수 있는 파티 개수의 최댓값은?
'''

def bfs():
    queue = []
    for p in range(N):
        if people[p]:
            queue.append(p)
    while queue:
        now = queue.pop(0)
        for chk in people_list[now]:
            if not people[chk]:
                people[chk] = True
                queue.append(chk)


# N은 사람 수, M은 파티 수
N, M = map(int, input().split())
# 진실을 아는 사람의 수와 그 사람 번호들
true_know_list = list(map(int, input().split()))
# 사람들의 번호는 1부터 N으로 주어짐
party = []
people_list = [[] for _ in range(N)]
people = [False]*N
for i in range(true_know_list[0]):
    people[true_know_list[1:][i]-1] = True


for m in range(M):
    # 파티에 오는 사람 수와 그 사람 번호들
    chk = list(map(int, input().split()))
    party.append(chk)
    
    for i in range(chk[0]):
        now = chk[1:][i]
        for j in range(chk[0]):
            if now != chk[1:][j]:
                people_list[now-1].append(chk[1:][j]-1)

bfs()

result = 0

for p in party:
    result += 1
    for i in range(p[0]):
        if people[p[1:][i]-1]:
            result -= 1
            break
print(result)


    
