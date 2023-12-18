#include <stdio.h>

int main() {
	int N, min = 1000000;
	int dp[3][1001] = { 0 };
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		int R, G, B;
		scanf("%d %d %d", &R, &G, &B);
		dp[0][i] = (dp[1][i - 1] < dp[2][i - 1] ? dp[1][i - 1] : dp[2][i - 1]) + R;
		dp[1][i] = (dp[0][i - 1] < dp[2][i - 1] ? dp[0][i - 1] : dp[2][i - 1]) + G;
		dp[2][i] = (dp[0][i - 1] < dp[1][i - 1] ? dp[0][i - 1] : dp[1][i - 1]) + B;
	}
	for (int i = 0; i < 3; i++)
		min = min < dp[i][N] ? min : dp[i][N];

	printf("%d", min);

	return 0;
}