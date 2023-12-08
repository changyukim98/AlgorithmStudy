import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            int next = input.charAt(i);
            if (Character.isDigit(next)) {
                stack.push(Character.getNumericValue(next));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;
                switch (next) {
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                }
                stack.push(result);
            }
        }
        System.out.println(stack.pop());
    }
}
