import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11651
public class Main {
    private static int[][] sorted;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        sorted = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(inputs[0]);
            arr[i][1] = Integer.parseInt(inputs[1]);
        }

        mergeSort(arr, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0])
                    .append(' ')
                    .append(arr[i][1])
                    .append('\n');
        }
        System.out.println(sb);
    }

    public static void mergeSort(int[][] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right);
    }

    public static void merge(int[][] arr, int left, int right) {
        int i = left;
        int mid = (left + right) / 2;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i][1] < arr[j][1]) {
                sorted[k++] = arr[i++];
            } else if (arr[i][1] == arr[j][1]) {
                if (arr[i][0] <= arr[j][0]) {
                    sorted[k++] = arr[i++];
                } else {
                    sorted[k++] = arr[j++];
                }
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
}
