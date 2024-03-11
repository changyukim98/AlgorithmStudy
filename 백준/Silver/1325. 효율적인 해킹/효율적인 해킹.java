import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] connection;
    private static boolean[] visited;
    private static int[] cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        connection = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            connection[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            connection[from].add(to);
        }

        Queue<Integer> result = new LinkedList<>();
        visited = new boolean[N + 1];
        cnt = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            DFS(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (max < cnt[i])
                max = cnt[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == max)
                sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    public static void DFS(int now) {
        visited[now] = true;
        for (Integer next : connection[now]) {
            if (visited[next]) continue;
            cnt[next]++;
            DFS(next);
        }
    }
}
