import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int rank1 = Integer.parseInt(st.nextToken());
                int rank2 = Integer.parseInt(st.nextToken());
                arr[rank1] = rank2;
            }

            int cnt = 0;
            int min = N + 1;
            for (int i = 1; i <= N; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
