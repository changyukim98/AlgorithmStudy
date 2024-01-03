import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static boolean[][] visited;
    private static char[][] floor;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        floor = new char[N][];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            floor[i] = input.toCharArray();
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    DFS(floor[i][j], i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void DFS(char tile, int y, int x) {
        visited[y][x] = true;
        if (tile == '-') {
            int[] dx = {-1, 1};
            for (int d = 0; d < 2; d++) {
                int new_x = x + dx[d];
                if (new_x < 0 || new_x > M - 1) continue;
                if (!visited[y][new_x] && floor[y][new_x] == tile) DFS(tile, y, new_x);
            }
        } else {
            int[] dy = {-1, 1};
            for (int d = 0; d < 2; d++) {
                int new_y = y + dy[d];
                if (new_y < 0 || new_y > N - 1) continue;
                if (!visited[new_y][x] && floor[new_y][x] == tile) DFS(tile, new_y, x);
            }
        }
    }
}
