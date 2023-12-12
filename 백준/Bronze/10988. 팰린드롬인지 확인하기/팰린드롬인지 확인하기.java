import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        int i = 0, j = input.length - 1;
        int result = 1;

        while (i < j) {
            if (input[i++] != input[j--]) {
                result = 0;
                break;
            }
        }

        System.out.println(result);
    }
}
