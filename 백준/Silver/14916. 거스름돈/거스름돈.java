import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int five = n / 5;
        if (n % 2 != five % 2) five--;
        n -= 5 * five;
        if (five < 0) System.out.println(-1);
        else {
            int two = n / 2;
            System.out.println(five+two);
        }
    }
}
