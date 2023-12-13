class Solution {
    private String[] sorted;

    public String solution(int[] numbers) {
        int len = numbers.length;

        String[] numStrArr = new String[numbers.length];
        sorted = new String[numbers.length];

        for (int i = 0; i < numStrArr.length; i++) {
            numStrArr[i] = String.valueOf(numbers[i]);
        }

        mergeSort(numStrArr, 0, len - 1);
        
        // 원소가 0만 있을 시 예외 처리
        if (numStrArr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numStrArr.length; i++) {
            sb.append(numStrArr[i]);
        }
        return sb.toString();
    }

    public void mergeSort(String[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right);
    }

    public void merge(String[] arr, int left, int right) {
        int i = left;
        int mid = (left + right) / 2;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            // 일반적인 mergeSort에서 비교부분을 변경
            if (priorityCompare(arr[i], arr[j]) <= 0) {
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

        for (int l = left; l <= right; l++) {
            arr[l] = sorted[l];
        }
    }

    public int priorityCompare(String a, String b) {
        int resultAB = Integer.parseInt(a + b);
        int resultBA = Integer.parseInt(b + a);

        if (resultAB > resultBA) return -1;
        else if (resultAB == resultBA) return 0;
        else return 1;
    }
}