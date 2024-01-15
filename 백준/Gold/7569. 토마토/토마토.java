import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        int cnt = 0;
        int[] dz = {-1, 0, 0, 0, 0, 1};
        int[] dy = {0, -1, 0, 0, 1, 0};
        int[] dx = {0, 0, -1, 1, 0, 0};

        while (true) {
            int size = queue.size();
            while (size-- > 0) {
                int[] now = queue.poll();
                int z = now[0];
                int y = now[1];
                int x = now[2];

                for (int d = 0; d < 6; d++) {
                    int newZ = z + dz[d];
                    int newY = y + dy[d];
                    int newX = x + dx[d];

                    if (newZ < 0 || newZ >= H) continue;
                    if (newY < 0 || newY >= N) continue;
                    if (newX < 0 || newX >= M) continue;

                    if (map[newZ][newY][newX] == 0) {
                        map[newZ][newY][newX] = 1;
                        queue.offer(new int[]{newZ, newY, newX});
                    }
                }
            }
            if (queue.isEmpty()) break;
            cnt++;
        }
        if (isAllTomatoRiped(map, H, N, M)) System.out.println(cnt);
        else System.out.println(-1);
    }

    public static boolean isAllTomatoRiped(int[][][] map, int H, int N, int M) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }
}
