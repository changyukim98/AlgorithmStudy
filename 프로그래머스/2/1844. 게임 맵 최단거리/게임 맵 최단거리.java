import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        boolean[][] visited = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] nextInfo = queue.poll();
            int y = nextInfo[0];
            int x = nextInfo[1];
            int distance = nextInfo[2];

            if (y == N - 1 && x == M - 1) {
                min = Math.min(min, distance);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int newY = y + dy[d];
                int newX = x + dx[d];

                if (newY < 0 || newY >= N) continue;
                if (newX < 0 || newX >= M) continue;
                if (maps[newY][newX] != 1) continue;
                if (visited[newY][newX]) continue;

                visited[newY][newX] = true;
                queue.add(new int[]{newY, newX, distance + 1});
            }
        }
        if (visited[N - 1][M - 1]) return min;
        else return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        });
    }
}
