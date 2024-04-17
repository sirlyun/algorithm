'''
    장르 별로 가장 많이 재생된 노래를 두개씩 모아 앨범 출시
    노래는 고유 번호(index)로 구분
    수록 기준
        1. 속한 노래가 많이 재생된 장르 먼저 수록
        2. 장르 내에서 많이 재생된 노래 먼저 수록
        3. 장르 내에서 재생 횟수가 같으면 고유 번호가 낮은 노래 먼저 수록
    앨범에 들어갈 노래의 고유 번호를 순서대로 반환
'''

def solution(genres, plays):
    answer = []
    
    n = len(genres)
    # 음악 정리
    musics = [[] for i in range(n)]
    for i in range(n):
        musics[i].append(i)
        musics[i].append(genres[i])
        musics[i].append(plays[i])
    # 재생 횟수 역순, 고유 번호 순으로 정렬
    musics.sort(key=lambda x: (-x[2], x[0]))
    
    genres_plays = {}
    for i in range(n):
        genres_plays.setdefault(genres[i], [0, 0])
        genres_plays[genres[i]][0] += plays[i]
    sorted_genres_plays = sorted(genres_plays.items(), key=lambda item:-item[1][0])
    
    for j in range(len(sorted_genres_plays)):
        for i in range(n):
            if sorted_genres_plays[j][0] == musics[i][1] and sorted_genres_plays[j][1][1] != 2:
                answer.append(musics[i][0])
                sorted_genres_plays[j][1][1] += 1
    
    return answer