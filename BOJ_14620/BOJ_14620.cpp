#include <iostream>
#include <vector>

using namespace std;
vector <vector<int>> V;
bool v[10][10] = { false };
int min_v = 10000000000;
int N;

int di[4] = { 0,1,0,-1 };
int dj[4] = { 1,0,-1,0 };

int cal(int si, int sj) {
	int summation = 0;

	summation += V[si][sj];
	v[si][sj] = true;

	for (int k = 0; k < 4; k++) {
		int ni = si + di[k];
		int nj = sj + dj[k];
		v[ni][nj] = true;
		summation += V[ni][nj];
	}

	//cout << si << sj << "의 summation " << summation << endl;

	return summation;
}

void func(int cnt, int cost) {
	if (cnt == 3) {

		if (cost < min_v) {
			min_v = cost;
		}

		return;
	}

	else if (cost > min_v) {
		return;
	}

	else {
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < N-1; j++) {
				int xx = 0; // 1이면 여기다가 씨앗 못 심음
				
				if (v[i][j] == true)
					continue;
				
				// 사방에 꽃잎이 있는지 확인
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k];
					int nj = j + dj[k];
					if (v[ni][nj] == true) {
						xx = 1;
						break;
					}
				}

				if (xx == 0) {
					int r = cal(i, j);
					func(cnt+1,cost+r);
					// 돌려놓기
					v[i][j] = false;
					for (int k = 0; k < 4; k++) {
						int ni = i + di[k];
						int nj = j + dj[k];
						v[ni][nj] = false;
					}
				}
			}
		}
	}
}


int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		vector <int> tmp;
		for (int j = 0; j < N; j++) {
			int x;
			cin >> x;
			tmp.push_back(x);
		}
		V.push_back(tmp);
	}

	func(0, 0);

	cout << min_v;

}