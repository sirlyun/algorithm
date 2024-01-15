#include <iostream>
#include <utility>
#include <vector>

using namespace std;

int main() {

	int N, M;
	cin >> N >> M;

	vector<pair <string, int>> info;
	vector<string> ans;


	for (int i = 0; i < N; i++) {
		string x;
		int y;
		cin >> x >> y;
		info.push_back(make_pair(x, y));
	}

	/*for (int i = 0; i < info.size(); i++) {
		cout << info[i].first << " " << info[i].second << endl;
	}*/

	for (int i = 0; i < M; i++) {
		int x;
		cin >> x;

		for (int j = 0; j < N; j++) {
			if (x <= info[j].second) {
				ans.push_back(info[j].first);
				break;
			}
		}
	}

	for (int i = 0; i < M; i++) {
		cout << ans[i] << endl;
	}
}
