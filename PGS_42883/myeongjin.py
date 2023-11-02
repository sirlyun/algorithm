def solution(number, k):
    n = len(number)
    arr = list(map(int, number))

    stack = []
    i = 0
    while True:

        if not stack:
            stack.append(arr[i])
            i += 1

        elif stack:

            while len(stack) > 0 and stack[-1] < arr[i] and k > 0:
                stack.pop()
                k -= 1

            if len(stack) == 0 or k == 0 or stack[-1] >= arr[i]:
                stack.append(arr[i])
                i += 1

        if i == n:
            break

    if k != 0:
        stack = stack[:-k]

    answer = ''.join(map(str, stack))
    return answer



# number = '1924'
# k = 2

# number = '1231234'
# k = 3

number = "4177252841"
k = 4
solution(number, k)