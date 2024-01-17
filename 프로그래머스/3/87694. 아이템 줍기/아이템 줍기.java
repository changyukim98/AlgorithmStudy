import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[][] map;
    private boolean[][] visited;
    private Queue<int[]> queue;

    // 상하좌우
    private int[] dy = {1, -1, 0, 0};
    private int[] dx = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[52][52];
        visited = new boolean[52][52];
        queue = new LinkedList<>();

        for (int[] rect : rectangle) drawRectangle(rect);
        for (int[] rect : rectangle) crossValidation(rect);
        for (int[] rect : rectangle) fillRectangle(rect);
        
        queue.offer(new int[]{characterY, characterX});
        visited[characterY][characterX] = true;

        return BFS(0, itemX, itemY);
    }

    public int BFS(int cnt, int itemX, int itemY) {
        int size = queue.size();
        while (size-- > 0) {
            int[] pos = queue.poll();
            int y = pos[0];
            int x = pos[1];
            if (x == itemX && y == itemY) return cnt;

            for (int d = 0, bit = 8; d < 4; d++, bit /= 2) {
                if ((map[y][x] & bit) == bit) {
                    int newY = y + dy[d];
                    int newX = x + dx[d];
                    if (!visited[newY][newX] && map[newY][newX] != 0) {
                        queue.offer(new int[]{newY, newX});
                        visited[newY][newX] = true;
                    }
                }
            }
        }
        if (queue.isEmpty()) return cnt;
        else return BFS(cnt + 1, itemX, itemY);
    }

    public void drawRectangle(int[] rectangle) {
        int x_start = rectangle[0];
        int y_start = rectangle[1];
        int x_end = rectangle[2];
        int y_end = rectangle[3];

        map[y_start][x_start] += 9;
        map[y_end][x_start] += 5;
        map[y_start][x_end] += 10;
        map[y_end][x_end] += 6;

        for (int y = y_start + 1; y < y_end; y++) {
            map[y][x_start] += 12;
            map[y][x_end] += 12;
        }
        for (int x = x_start + 1; x < x_end; x++) {
            map[y_start][x] += 3;
            map[y_end][x] += 3;
        }
    }

    public void crossValidation(int[] rectangle) {
        int x_start = rectangle[0];
        int y_start = rectangle[1];
        int x_end = rectangle[2];
        int y_end = rectangle[3];

        for (int y = y_start + 1; y < y_end; y++) {
            if ((map[y][x_start] & 1) == 1) map[y][x_start] -= 1;
            if ((map[y][x_end] & 2) == 2) map[y][x_end] -= 2;
        }
        for (int x = x_start + 1; x < x_end; x++) {
            if ((map[y_start][x] & 8) == 8) map[y_start][x] -= 8;
            if ((map[y_end][x] & 4) == 4) map[y_end][x] -= 4;
        }
    }

    public void fillRectangle(int[] rectangle) {
        int x_start = rectangle[0];
        int y_start = rectangle[1];
        int x_end = rectangle[2];
        int y_end = rectangle[3];

        for (int x = x_start + 1; x < x_end; x++) {
            for (int y = y_start + 1; y < y_end; y++) {
                map[y][x] = 0;
            }
        }
    }
}