import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10867
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] arr = new int[N];
        boolean[] isUsed = new boolean[2001];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(inputs[i]);
            if (isUsed[num + 1000]) continue;
            isUsed[num + 1000] = true;
            arr[cnt++] = num;
        }

        quickSort(arr, 0, cnt - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }

    public static void quickSort(int[] arr, int left, int right) {
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

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
