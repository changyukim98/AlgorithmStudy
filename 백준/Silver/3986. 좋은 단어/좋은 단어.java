import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        Stack<Character> stack = new Stack<>();
        for (int n = 0; n < N; n++) {
            String input = br.readLine();
            int len = input.length();

            for (int i = 0; i < len; i++) {
                char next = input.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(next);
                } else {
                    if (stack.peek() == next) stack.pop();
                    else stack.push(next);
                }
            }
            if (stack.isEmpty()) cnt++;
            stack.clear();
        }
        System.out.println(cnt);
    }
}
