def find_knowpeople(people) :

    global know_people

    length = len(know_people)

    idx = 0

    is_update = 0

    for i in arr :

        new_i = set(i[1:])

        if len(know_people & new_i) != 0 :

            know_people.update(new_i)
            check[idx] = 1

        idx +=1

    if length != len(know_people) :

        is_update = 1

    return is_update


N, M = map(int,input().split())

people = list(map(int,input().split()))

arr = [list(map(int,input().split())) for _ in range(M)]
check = [0 for _ in range(M)]

cnt = 0

if people[0] == 0 :

    print(M)
    exit()

else :

    count_know_people = people.pop(0)
    know_people = set(people)

    while True :

        is_update = find_knowpeople(people)

        if is_update == 0 :

            break

    # print('arr',arr)
    # print(check)
    # print('know',know_people)

    for i in range(len(arr)) :

        if check[i] == 1 :

            continue

        else :

            new_i = set(arr[i][1:])

            if len(know_people & new_i) == 0 :

                cnt += 1

    print(cnt)
