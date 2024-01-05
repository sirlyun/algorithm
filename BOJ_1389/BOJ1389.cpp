// bfs는 넣을 때 방문 표시를 한다.

#include <iostream>
#include <queue>
#include <vector>

using namespace std;

// 벡터를 함수에서 활용해야 하기 때문에 전역 변수로 지정
vector <vector<int>> v;
vector <int> tmp;

int N, M;
int min_v = 100000000;
int ans = 0;


void bfs(int start) {
	//int visited[100] = { -1, };
	vector <int> visited;
	for (int i = 0; i < N; i++) {
		visited.push_back(-1);
	}
	int summation = 0;

	queue <int> q;
	q.push(start);
	visited[start] += 1;

	while (!q.empty()) {
		// 큐에서 하나 빼기
		int now = q.front();
		summation += visited[now];
		q.pop();

		// 인접 리스트 확인
		for (int i = 0; i < v[now].size(); i++) {
			int next = v[now][i];
			if (visited[next] != -1) continue;

			q.push(next);
			visited[next] = visited[now] + 1;
		}
	}

	if (min_v >= summation) {
		min_v = summation;
		ans = start;
	}
}

int main() {

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		v.push_back(tmp);
	}

	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;
		x--;
		y--;
		v[x].push_back(y);
		v[y].push_back(x);
	}

	for (int i = N-1; i >= 0; i--) {
		bfs(i);
	}

	cout << ans+1;
}