import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static char[][] map;
    private static boolean[][] visited;
    private static Queue<int[]> queue = new LinkedList<>();
    private static int[] dy = {0, 0, -1, 1};
    private static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    resetVisited();

                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    result = Math.max(result, BFS(0));
                }
            }
        }
        System.out.println(result);
    }

    public static int BFS(int cnt) {
        int size = queue.size();
        while (size-- > 0) {
            int y = queue.peek()[0];
            int x = queue.peek()[1];

            for (int d = 0; d < 4; d++) {
                int newY = y + dy[d];
                int newX = x + dx[d];

                if (newY < 0 || newY >= N) continue;
                if (newX < 0 || newX >= M) continue;
                if (!visited[newY][newX] && map[newY][newX] == 'L') {
                    visited[newY][newX] = true;
                    queue.offer(new int[]{newY, newX});
                }
            }
            queue.poll();
        }
        if (queue.isEmpty()) return cnt;
        else return BFS(cnt + 1);
    }

    public static void resetVisited() {
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }
}
