import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int cur = N - 1;
        while (K > 0) {
            int coin = coins[cur];
            if (coin <= K) {
                int cnt = K / coin;
                K -= coin * cnt;
                result += cnt;
            }
            cur--;
        }

        System.out.println(result);
    }
}
