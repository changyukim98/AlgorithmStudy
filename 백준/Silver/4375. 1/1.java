import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            int target = Integer.parseInt(input);

            BigInteger dividend = new BigInteger("1");
            int cnt = 1;
            while (!dividend.mod(new BigInteger(String.valueOf(target)))
                    .equals(new BigInteger("0"))
            ) {
                dividend = dividend
                        .multiply(new BigInteger("10"))
                        .add(new BigInteger("1"));
                cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
