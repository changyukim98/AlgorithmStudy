import java.util.Arrays;

class Solution {
    private int[] sorted;

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        sorted = new int[array.length];

        for (int i = 0; i < commands.length; i++) {
            int left = commands[i][0];
            int right = commands[i][1];
            int k = commands[i][2];

            int[] tempArray = Arrays.copyOfRange(array, left - 1, right);
            mergeSort(tempArray, 0, right - left);
            answer[i] = tempArray[k - 1];
        }
        return answer;
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right);
    }

    public void merge(int[] arr, int left, int right) {
        int i = left;
        int mid = (left + right) / 2;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            } else {
                sorted[k++] = arr[j++];
            }
        }

        for (; i <= mid; i++, k++) {
            sorted[k] = arr[i];
        }

        for (; j <= right; j++, k++) {
            sorted[k] = arr[j];
        }

        for (int l = left; l <= right ; l++) {
            arr[l] = sorted[l];
        }
    }
}
