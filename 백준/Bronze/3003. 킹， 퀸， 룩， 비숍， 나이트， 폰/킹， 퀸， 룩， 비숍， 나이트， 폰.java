import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] chessPeace = {1, 1, 2, 2, 2, 8};

        String input = br.readLine();
        String[] myChessPeace = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int myChessNum = Integer.parseInt(myChessPeace[i]);
            sb.append(chessPeace[i] - myChessNum).append(" ");
        }
        System.out.println(sb);

        br.close();
    }
}
