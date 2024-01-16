import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static boolean[][] friendMap;
    private static boolean[] visited;
    private static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        friendMap = new boolean[N + 1][N + 1];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            if (p1 == -1 && p2 == -1) break;

            friendMap[p1][p2] = friendMap[p2][p1] = true;
        }

        int min = N;
        List<Integer> result = new ArrayList<>();
        visited = new boolean[N + 1];
        queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.clear();
            Arrays.fill(visited, false);

            visited[i] = true;
            queue.offer(i);

            int distance = BFS(0);
            if (distance < min) {
                min = distance;
                result.clear();
                result.add(i);
            } else if (distance == min) {
                result.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(' ').append(result.size()).append('\n');
        for (Integer i : result) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    public static int BFS(int cnt) {
        int size = queue.size();
        while (size-- > 0) {
            int x = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && friendMap[x][i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        if (queue.isEmpty()) return cnt;
        else return BFS(cnt + 1);
    }
}