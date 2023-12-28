class Solution {
    private int max = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        perm(dungeons, visited, k, 0);
        return max;
    }

    public void perm(int[][] dungeons, boolean[] visited, int k, int cnt) {
        max = Math.max(max, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (k < dungeons[i][0]) continue;
            visited[i] = true;
            perm(dungeons, visited, k - dungeons[i][1], cnt + 1);
            visited[i] = false;
        }
    }
}