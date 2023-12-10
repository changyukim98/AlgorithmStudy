import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] consults = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] consInfo = br.readLine().split(" ");
            consults[i][0] = Integer.parseInt(consInfo[0]);
            consults[i][1] = Integer.parseInt(consInfo[1]);
        }
        comb(consults, N, 0, 0);

        System.out.println(max);
    }

    public static void comb(int[][] consults, int N, int cur, int sum) {
        if (cur > N) return;
        else if (cur == N) {
            max = Math.max(max, sum);
            return;
        }
        // consult[cur] 미 선택 시
        comb(consults, N, cur + 1, sum);
        // consults[cur] 선택 시
        comb(consults, N, cur + consults[cur][0], sum + consults[cur][1]);
    }
}