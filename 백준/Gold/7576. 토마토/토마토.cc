#include <stdio.h>
#include <queue>
using namespace std;

int M, N;
int tomato[1002][1002];
int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };
queue<pair<int, int>> q;

bool check() {
	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= M; j++)
			if (tomato[i][j] == 0)
				return false;
	return true;
}
int BFS(int cnt) {
	int size = q.size();
	while (size--) {
		int i = q.front().first;
		int j = q.front().second;
		for (int d = 0; d < 4; d++) {
			int y = i + dy[d];
			int x = j + dx[d];
			bool isSafe = (x >= 1 && x <= M && y >= 1 && y <= N);
			if (isSafe && tomato[y][x] == 0) {
				q.push(make_pair(y, x));
				tomato[y][x] = 1;
			}
		}
		q.pop();
	}
	if (q.empty()) return cnt;
	return BFS(cnt + 1);
}
void solve() {
	if (check()) {
		printf("0");
		return;
	}
	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= M; j++)
			if (tomato[i][j] == 1)
				q.push(make_pair(i, j));

	int cnt = BFS(0);

	if (check())
		printf("%d", cnt);
	else
		printf("-1");
}
int main() {
	scanf("%d %d", &M, &N);
	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= M; j++)
			scanf("%d", &tomato[i][j]);
	solve();

	return 0;
}