import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Set<Integer>> setMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int gcd = calcGcd(x, y);

            x /= gcd;
            y /= gcd;
            if (!setMap.containsKey(x)) setMap.put(x, new HashSet<>());
            Set<Integer> set = setMap.get(x);
            set.add(y);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : setMap.entrySet()) {
            cnt += entry.getValue().size();
        }
        System.out.println(cnt);
    }

    public static int calcGcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
