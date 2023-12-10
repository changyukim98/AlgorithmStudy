#include <stdio.h>

int max(int a, int b) { return a > b ? a : b; }
int main() {
	int N;
	int arr[16][2];
	int dp[17] = { 0 };

	scanf("%d", &N);
	for (int i = 1; i <= N; i++)
		scanf("%d %d", &arr[i][0], &arr[i][1]);
	for (int i = 1; i <= N + 1; i++) {
		dp[i] = dp[i - 1];
		for (int j = 1; j < i; j++) {
			if (j + arr[j][0] == i)
				dp[i] = max(dp[i], dp[j] + arr[j][1]);
		}
	}
	printf("%d", dp[N + 1]);

	return 0;
}