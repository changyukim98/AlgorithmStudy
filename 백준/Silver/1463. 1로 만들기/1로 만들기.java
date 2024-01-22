import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[N] = 0;
//        dp[i] = 숫자 i를 만들기 위해 N으로 부터 연산한 최소 횟수
//        dp[i] = Math.min(dp[i+1], dp[i*2], dp[i*3]) + 1;
        for (int i = N - 1; i >= 1; i--) {
            dp[i] = dp[i + 1] + 1;
            if (i * 2 <= N) dp[i] = Math.min(dp[i], dp[i * 2] + 1);
            if (i * 3 <= N) dp[i] = Math.min(dp[i], dp[i * 3] + 1);
        }
        System.out.println(dp[1]);
    }
}