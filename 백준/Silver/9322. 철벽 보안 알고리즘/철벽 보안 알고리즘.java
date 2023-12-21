import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Map<String, Integer> key1Map = new HashMap<>();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] key1 = br.readLine().split(" ");
            String[] key2 = br.readLine().split(" ");
            String[] cipher = br.readLine().split(" ");
            String[] plain = new String[N];

            for (int i = 0; i < N; i++) {
                key1Map.put(key1[i], i);
            }

            for (int i = 0; i < N; i++) {
                int key1Idx = key1Map.get(key2[i]);
                plain[key1Idx] = cipher[i];
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(plain[i]).append(' ');
            }
            System.out.println(sb);
        }
    }
}
