import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int max = 0, cnt = 0;
        while (!stack.isEmpty()) {
            int h = stack.pop();
            if (h > max) {
                max = h;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}