import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arrayInputs = br.readLine().split(" ");

        int[] arr = new int[arrayInputs.length];
        for (int i = 0; i < arrayInputs.length; i++) {
            arr[i] = Integer.parseInt(arrayInputs[i]);
        }

        Arrays.sort(arr);
        // M값 미사용
        br.readLine();

        StringTokenizer targets = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (targets.hasMoreTokens()) {
            int target = Integer.parseInt(targets.nextToken());
            if (binarySearch(arr, 0, N - 1, target)) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }

        System.out.println(sb);
    }

    public static boolean binarySearch(int[] arr, int start, int end, int target) {
        if (start > end) return false;

        int mid = (start + end) / 2;
        if (arr[mid] == target) return true;
        else if (arr[mid] < target)
            return binarySearch(arr, mid + 1, end, target);
        else
            return binarySearch(arr, start, mid - 1, target);
    }
}
