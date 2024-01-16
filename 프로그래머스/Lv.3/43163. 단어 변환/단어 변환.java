import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private Queue<Integer> queue;
    boolean[][] adjMap;
    private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        adjMap = new boolean[words.length][words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                int cnt = 0;
                for (int k = 0; k < words[i].length(); k++) {
                    if (words[i].charAt(k) != words[j].charAt(k)) {
                        cnt++;
                        if (cnt >= 2) break;
                    }
                }
                if (cnt == 1) adjMap[i][j] = true;
            }
        }

        queue = new LinkedList<>();
        visited = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            int cnt = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    cnt++;
                    if (cnt >= 2) break;
                }
            }
            if (cnt == 1) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        return BFS(words, target, 1);
    }

    public int BFS(String[] words, String target, int cnt) {
        int size = queue.size();
        while (size-- > 0) {
            int x = queue.poll();
            if (target.equals(words[x])) return cnt;

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && adjMap[x][i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        if (queue.isEmpty()) return 0;
        else return BFS(words, target, cnt + 1);
    }
}