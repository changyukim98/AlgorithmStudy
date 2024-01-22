import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 3; i <= N; i++) {
            if (i - 3 >= 0 && dp[i - 3] != -1) {
                dp[i] = dp[i - 3] + 1;
            }
            if (i - 5 >= 0 && dp[i - 5] != -1) {
                if (dp[i] != -1) {
                    dp[i] = Math.min(dp[i], dp[i - 5] + 1);
                } else {
                    dp[i] = dp[i - 5] + 1;
                }
            }
        }
        System.out.println(dp[N]);
    }
}
