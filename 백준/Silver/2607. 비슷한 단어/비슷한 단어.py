'''
    같은 구성을 갖는 조건
        1. 두 개의 단어가 같은 종류의 문자로 이루어짐
        2. 같은 문자는 같은 개수만큼 있음
    
    두 단어가 같은 구성을 갖는 경우
    한 단어에서 한 문자를 더하거나, 빼거나 하나의 문자를 다른 문자로 치환해서
    같은 구성이 되는 경우 비슷한 단어라고 함

    여러 개의 서로 다른 단어가 주어질 때,
    첫 번째 단어와 비슷한 단어가 모두 몇개인가
'''

def sim(word, check):
    global result

    word_alpha = [0] * 26
    diff = len(word) - len(check)
    # 글자 수 차이가 1보다 크면 불가능
    if abs(diff) > 1:
        return
    
    for w in word:
        word_alpha[ord(w) - ord('A')] += 1

    count = 0
    for c in check:
        tmp = ord(c) - ord('A')
        # 겹치는 단어일 경우 카운팅
        if word_alpha[tmp] > 0:
            count += 1
            word_alpha[tmp] -= 1

    # 차이가 1이고 카운팅 차이도 1이면 가능
    if diff == 1:
        if len(word) - 1 == count:
            result += 1
    elif diff == -1:
        if len(check) - 1 == count:
            result += 1
    # 차이가 없으면 단어가 똑같거나 카운팅 차이가 1이여서 대체할 수 있으면 가능
    else:
        if len(word) == count or len(word) - 1 == count:
            result += 1
    return


N = int(input())
word = input()
result = 0
for _ in range(N-1):
    check = input()
    sim(word, check)

print(result)