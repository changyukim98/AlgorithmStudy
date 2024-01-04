class Solution {
    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        int cnt = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(computers, n, i);
                cnt++;
            }
        }
        return cnt;
    }

    public void DFS(int[][] computers, int n, int x) {
        visited[x] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && computers[x][i] == 1) {
                DFS(computers, n, i);
            }
        }
    }
}