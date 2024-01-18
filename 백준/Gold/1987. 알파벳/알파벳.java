import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static char[][] board;
    private static boolean[] used;
    private static boolean[][] visited;
    private static final int[] dy = {-1, 0, 0, 1};
    private static final int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];
        used = new boolean[26];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        used[board[0][0] - 65] = true;
        visited[0][0] = true;
        System.out.println(DFS(R, C, 0, 0));
    }

    public static int DFS(int R, int C, int y, int x) {
        int max = 0;
        for (int d = 0; d < 4; d++) {
            int newY = y + dy[d];
            int newX = x + dx[d];

            if (newY < 0 || newY >= R) continue;
            if (newX < 0 || newX >= C) continue;

            char next = board[newY][newX];
            if (!used[next - 65] && !visited[newY][newX]) {
                used[next - 65] = true;
                visited[newY][newX] = true;
                max = Math.max(max, DFS(R, C, newY, newX));
                used[next - 65] = false;
                visited[newY][newX] = false;
            }
        }
        return max + 1;
    }
}
