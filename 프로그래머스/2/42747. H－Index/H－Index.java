class Solution {
    public int solution(int[] citations) {
        quickSort(citations, 0, citations.length - 1);

        int HIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            // citations[i]보다 큰 논문의 개수
            int cnt = citations.length - i;
            // 처음 발견했을 때 HIndex가 최대값임
            if (citations[i] >= cnt) {
                HIndex = cnt;
                break;
            }
        }

        return HIndex;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int low = left + 1;
        int high = right;

        // left가 pivot
        while (low <= high) {
            if (arr[low] <= arr[left]) {
                low++;
                continue;
            }
            if (arr[high] >= arr[left]) {
                high--;
                continue;
            }
            swap(arr, low, high);
        }

        swap(arr, left, high);
        quickSort(arr, left, high - 1);
        quickSort(arr, high + 1, right);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}