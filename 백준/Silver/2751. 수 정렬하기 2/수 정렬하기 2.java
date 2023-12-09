import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] isUsed = new boolean[2000001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine()) + 1000000;
            isUsed[num] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 2000000; i++) {
            if (isUsed[i]) sb.append(i - 1000000).append('\n');
        }
        System.out.println(sb);
    }
}
