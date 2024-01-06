import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private Queue<Point> queue = new LinkedList<>();
    private int[] dy = {0, 0, -1, 1};
    private int[] dx = {-1, 1, 0, 0};

    public int solution(int[][] maps) {
        queue.offer(new Point(0, 0));
        maps[0][0] = 0;
        int result = BFS(maps, 1);
        return result;
    }

    public int BFS(int[][] maps, int cnt) {
        int N = maps.length;
        int M = maps[0].length;

        int size = queue.size();
        while (size-- > 0) {
            Point p = queue.poll();
            int y = p.y;
            int x = p.x;

            if (y == N - 1 && x == M - 1) return cnt;

            for (int d = 0; d < 4; d++) {
                int newY = y + dy[d];
                int newX = x + dx[d];

                if (newY < 0 || newY >= N) continue;
                if (newX < 0 || newX >= M) continue;
                if (maps[newY][newX] == 1) {
                    maps[newY][newX] = 0;
                    queue.offer(new Point(newY, newX));
                }
            }
        }

        if (queue.isEmpty()) return -1;
        else return BFS(maps, cnt + 1);
    }
}