#include <stdio.h>
#include <stdlib.h>
int arr[2][100000];
int sorted[2][100000];

void merge(int** arr, int left, int mid, int right) {
	int i = left;
	int j = mid + 1;
	int k = left;

	while (i <= mid && j <= right) {
		if (arr[1][i] < arr[1][j]) {
			sorted[0][k] = arr[0][i];
			sorted[1][k++] = arr[1][i++];
		}
		else if (arr[1][i] == arr[1][j]) {
			if (arr[0][i] < arr[0][j]) {
				sorted[0][k] = arr[0][i];
				sorted[1][k++] = arr[1][i++];
			}
			else {
				sorted[0][k] = arr[0][j];
				sorted[1][k++] = arr[1][j++];
			}
		}
		else {
			sorted[0][k] = arr[0][j];
			sorted[1][k++] = arr[1][j++];
		}
	}
	for (; i <= mid; i++) {
		sorted[0][k] = arr[0][i];
		sorted[1][k++] = arr[1][i];
	}
	for (; j <= right; j++) {
		sorted[0][k] = arr[0][j];
		sorted[1][k++] = arr[1][j];
	}
	for (int l = left; l <= right; l++) {
		arr[0][l] = sorted[0][l];
		arr[1][l] = sorted[1][l];
	}
}
void merge_sort(int** arr, int left, int right) {
	int mid = (right + left) / 2;

	if (left < right) {
		merge_sort(arr, left, mid);
		merge_sort(arr,  mid + 1, right);
		merge(arr, left, mid, right);
	}
}
int main() {
	int N;

	scanf("%d", &N);
	int** arr = (int**)malloc(sizeof(int*) * 2);
	for (int i = 0; i < 2; i++) {
		arr[i] = (int*)malloc(sizeof(int) * N);
	}
	for (int i = 0; i < N; i++)
		scanf("%d %d", &arr[0][i], &arr[1][i]);


	merge_sort(arr, 0, N - 1);
	for (int i = 0; i < N; i++) {
		printf("%d %d\n", arr[0][i], arr[1][i]);
	}

	return 0;
}