import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// https://www.acmicpc.net/problem/2217
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] ropes = new Integer[N];

        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes, Collections.reverseOrder());

        int maxDurable = 0;
        for (int i = 0; i < N; i++) {
            int durable = ropes[i] * (i + 1);
            maxDurable = Math.max(maxDurable, durable);
        }

        System.out.println(maxDurable);
    }
}