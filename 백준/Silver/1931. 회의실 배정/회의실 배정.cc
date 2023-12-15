#include <stdio.h>

int arr[100000][2];
int sorted[100000][2];

void merge(int index, int left, int mid, int right) {
	int i = left;
	int j = mid + 1;
	int k = left;

	while (i <= mid && j <= right) {
		if (arr[i][index] < arr[j][index]) {
			sorted[k][0] = arr[i][0];
			sorted[k++][1] = arr[i++][1];
		}
		else {
			sorted[k][0] = arr[j][0];
			sorted[k++][1] = arr[j++][1];
		}
	}
	for (; i <= mid;) {
		sorted[k][0] = arr[i][0];
		sorted[k++][1] = arr[i++][1];
	}
	for (; j <= right;) {
		sorted[k][0] = arr[j][0];
		sorted[k++][1] = arr[j++][1];
	}
	for (int l = left; l <= right; l++) {
		arr[l][0] = sorted[l][0];
		arr[l][1] = sorted[l][1];
	}
}
void merge_sort(int index, int left, int right) {
	int mid = (left + right) / 2;
	if (left < right) {
		merge_sort(index, left, mid);
		merge_sort(index, mid + 1, right);
		merge(index, left, mid, right);
	}
}

int main() {
	int N, time = 0, cnt = 0;

	scanf("%d", &N);
	for (int i = 0; i < N; i++)
		scanf("%d %d", &arr[i][0], &arr[i][1]);
	merge_sort(1, 0, N - 1);

	int left = 0;
	int val = arr[0][1];
	for (int i = 1; i < N; i++) {
		if (arr[i][1] > val) {
			merge_sort(0, left, i - 1);
			left = i;
			val = arr[i][1];
		}
	}
	merge_sort(0, left, N - 1);
	for (int i = 0; i < N; i++) {
		if (arr[i][0] >= time) {
			time = arr[i][1];
			cnt++;
		}
	}
	printf("%d", cnt);

	return 0;
}