import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] edgesList;
    private static boolean[] visited;
    private static Queue<int[]> queue;
    private static int[] colors;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        edgesList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            edgesList[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        colors = new int[N + 1];
        queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            edgesList[U].add(V);
            edgesList[V].add(U);
        }
        if (colors[1] != 0) answer++;
        visited[1] = true;
        queue.offer(new int[]{1, colors[1]});
        BFS();
        System.out.println(answer);
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int cur = front[0];
            int color = front[1];
            for (Integer i : edgesList[cur]) {
                if (visited[i]) continue;
                if (colors[i] != color) answer++;
                visited[i] = true;
                queue.offer(new int[]{i, colors[i]});
            }
        }
    }
}
