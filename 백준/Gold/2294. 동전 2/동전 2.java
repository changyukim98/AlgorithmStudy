import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> coins = new HashSet<>();
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (Integer coin : coins) {
            for (int i = 1; i <= k; i++) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    if (dp[i] == -1) dp[i] = dp[i - coin] + 1;
                    else dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[k]);
    }
}
