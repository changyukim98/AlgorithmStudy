import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Set<Integer>[] adjMap;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjMap = new Set[N];
        for (int i = 0; i < N; i++) {
            adjMap[i] = new HashSet<>();
        }

        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjMap[a].add(b);
            adjMap[b].add(a);
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            if (DFS(N, i, 1)) {
                answer = 1;
                break;
            }
            visited[i] = false;
        }
        System.out.println(answer);
    }

    public static boolean DFS(int N, int x, int cnt) {
        if (cnt == 5) return true;
        for (Integer i : adjMap[x]) {
            if (!visited[i]) {
                visited[i] = true;
                if (DFS(N, i, cnt + 1)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
