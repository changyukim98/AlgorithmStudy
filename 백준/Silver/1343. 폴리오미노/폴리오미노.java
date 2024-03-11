import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();
        StringTokenizer st = new StringTokenizer(board, ".");

        boolean success = true;
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.length() % 2 != 0) {
                success = false;
                break;
            }
            int aNum = token.length() / 4;
            int bNum = (token.length() - aNum * 4) / 2;

            String replacement = "AAAA".repeat(aNum) + "BB".repeat(bNum);
            board = board.replaceFirst("X+", replacement);
        }

        if (success) System.out.println(board);
        else System.out.println(-1);
    }
}
