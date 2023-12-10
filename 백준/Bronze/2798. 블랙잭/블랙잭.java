import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        comb(cards, 0, 0, 0);
        System.out.println(max);
    }

    public static void comb(int[] cards, int cnt, int cur, int sum) {
        if (cnt == 3 && sum <= M) {
            max = Math.max(max, sum);
        } else {
            if (cur >= N) return;
            if (sum > M) return;
            comb(cards, cnt, cur + 1, sum);
            comb(cards, cnt + 1, cur + 1, sum + cards[cur]);
        }
    }
}