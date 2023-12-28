class Solution {
    private boolean[][] graph;

    public int solution(int n, int[][] wires) {
        graph = new boolean[n + 1][n + 1];

        // wires를 전부 돌면서 그래프에 노드 연결상태 저장
        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];
            graph[from][to] = graph[to][from] = true;
        }

        // wires를 돌면서 해당 wire의 연결을 끊음
        int answer = n;
        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];
            boolean[] visited = new boolean[n + 1];
            //연결 끊기
            graph[from][to] = graph[to][from] = false;
            visited[from] = visited[to] = true;
            // from과 to 각각에서 DFS탐색
            int result = Math.abs(DFS(n, from, visited) - DFS(n, to, visited));
            // 연결 복구
            graph[from][to] = graph[to][from] = true;
            answer = Math.min(answer, result);
        }

        return answer;
    }

    public int DFS(int n, int node, boolean[] visited) {
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] && !visited[i]) {
                visited[i] = true;
                cnt += DFS(n, i, visited);
            }
        }
        return cnt;
    }
}