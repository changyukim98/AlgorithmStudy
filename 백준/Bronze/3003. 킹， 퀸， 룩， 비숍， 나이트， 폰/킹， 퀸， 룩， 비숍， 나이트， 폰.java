import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] chessPeace = {1, 1, 2, 2, 2, 8};

        String input = br.readLine();
        String[] myChessPeace = input.split(" ");
        for (int i = 0; i < 6; i++) {
            int myChessNum = Integer.parseInt(myChessPeace[i]);
            bw.write(chessPeace[i] - myChessNum + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
