import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();
            if (isFoldable(s, 0, s.length() - 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isFoldable(String s, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            for (int i = start; i < mid; i++) {
                if (s.charAt(i) == s.charAt(end - i))
                    return false;
            }
            boolean leftResult = isFoldable(s, start, mid - 1);
            boolean rightResult = isFoldable(s, mid + 1, end);
            return leftResult && rightResult;
        }
        return true;
    }
}
