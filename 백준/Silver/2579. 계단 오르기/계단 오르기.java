import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[][] dp = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1][0] = arr[1];
        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
            dp[i][1] = dp[i - 1][0] + arr[i];
        }
        
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
