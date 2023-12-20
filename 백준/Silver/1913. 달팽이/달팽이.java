import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M, targetI, targetJ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // direction 0, 1, 2, 3 -> 북, 동, 남, 서
        map[N / 2][N / 2] = 1;
        snail(0, 0, N / 2, N / 2, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        sb.append(targetI + 1).append(' ').append(targetJ + 1);
        System.out.println(sb);
    }

    public static void snail(int direction, int dist, int y, int x, int cnt) {
        if (direction % 2 == 0) dist += 1;
        for (int d = 0; d < dist; d++) {
            if (cnt == M) {
                targetI = y;
                targetJ = x;
            }
            y += dy[direction];
            x += dx[direction];
            if (y < 0) return;
            cnt++;
            map[y][x] = cnt;
        }
        direction = (direction + 1) % 4;
        snail(direction, dist, y, x, cnt);
    }
}
