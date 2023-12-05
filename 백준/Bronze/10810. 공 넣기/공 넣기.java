import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        String input = br.readLine();
        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);
        
        int[] baskets = new int[N + 1];
        for (int m = 0; m < M; m++) {
            input = br.readLine();
            int i = Integer.parseInt(input.split(" ")[0]);
            int j = Integer.parseInt(input.split(" ")[1]);
            int k = Integer.parseInt(input.split(" ")[2]);

            for (int x = i; x <= j; x++) baskets[x] = k;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(baskets[i]).append(' ');
        }
        System.out.println(sb);
    }
}
