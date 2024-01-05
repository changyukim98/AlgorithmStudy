import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        int cnt = 0;
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};
        while (true) {
            int size = queue.size();
            while (size-- > 0) {
                Point point = queue.poll();
                int y = point.y;
                int x = point.x;

                for (int d = 0; d < 4; d++) {
                    int newY = y + dy[d];
                    int newX = x + dx[d];

                    if (newY < 0 || newY >= N) continue;
                    if (newX < 0 || newX >= M) continue;

                    if (map[newY][newX] == 0) {
                        map[newY][newX] = 1;
                        queue.offer(new Point(newY, newX));
                    }
                }
            }
            if (queue.isEmpty()) break;
            cnt++;
        }
        if (isAllTomatoRiped(map, N, M)) System.out.println(cnt);
        else System.out.println(-1);
    }

    public static boolean isAllTomatoRiped(int[][] map, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }
}
