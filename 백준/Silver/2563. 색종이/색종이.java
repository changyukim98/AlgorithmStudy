import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[100][100];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);

            for (int y = Y; y < Y + 10; y++) {
                for (int x = X; x < X + 10; x++) {
                    map[y][x] = true;
                }
            }
        }
        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j]) area++;
            }
        }

        System.out.println(area);
    }
}
