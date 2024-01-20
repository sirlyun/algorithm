num = input()
result = 0

while True:
    result += 1
    N = str(result)
    while len(num) > 0 and len(N) > 0:
        if N[0] == num[0]:
            num = num[1:]
        N = N[1:]
    
    if num == '':
        print(result)
        break