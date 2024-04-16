'''
    한 번호가 다른 번호의 접두어인 경우 확인
'''

def solution(phone_book):
    phone_book.sort()
    for i in range(1, len(phone_book)):
        if phone_book[i-1] == phone_book[i][:len(phone_book[i-1])]:
            return False
    
    return True