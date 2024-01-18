import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] subCount;
    private static boolean[] visited;
    private static List<Integer>[] edgesList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        edgesList = new List[N + 1];
        subCount = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            edgesList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            edgesList[U].add(V);
            edgesList[V].add(U);
        }
        
        DFS(R);

        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int target = Integer.parseInt(br.readLine());
            sb.append(subCount[target]).append('\n');
        }
        System.out.println(sb);
    }

    public static int DFS(int cur) {
        visited[cur] = true;
        int cnt = 1;
        for (int i : edgesList[cur]) {
            if (!visited[i]) {
                cnt += DFS(i);
            }
        }
        subCount[cur] = cnt;
        return cnt;
    }
}
