import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (".".equals(input)) break;
            if(isBalancedStr(input)) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }

    public static boolean isBalancedStr(String str) {
        Stack<Character> stack = new Stack<>();
        int strLen = str.length();

        for (int i = 0; i < strLen; i++) {
            char next = str.charAt(i);
            if (next == '(' || next == '[') {
                stack.push(next);
            } else if (next == ')') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '(') return false;
            } else if (next == ']') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
