import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] cardTexts = br.readLine().split(" ");

        int[] cardNums = new int[N];
        for (int i = 0; i < N; i++) {
            cardNums[i] = Integer.parseInt(cardTexts[i]);
        }
        Arrays.sort(cardNums);

        int M = Integer.parseInt(br.readLine());
        String[] targets = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
                int targetNum = Integer.parseInt(targets[i]);
                if (binarySearch(cardNums, 0, N - 1, targetNum))
                    sb.append(1).append(' ');
                else sb.append(0).append(' ');
        }

        System.out.println(sb);
    }

    public static boolean binarySearch(int[] arr, int start, int end, int target) {
        if (start > end) return false;

        int mid = (start + end) / 2;
        if (arr[mid] == target) return true;
        else if (arr[mid] < target) return binarySearch(arr, mid + 1, end, target);
        else return binarySearch(arr, start, mid - 1, target);
    }
}
