class Solution {
    private boolean[] visited;

    public int solution(String name) {
        visited = new boolean[name.length()];

        int cnt = 0;
        int result = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') {
                cnt++;
                visited[i] = true;
            } else {
                result += makeLetter(name.charAt(i));
            }
        }
        if (!visited[0]) {
            cnt++;
            visited[0] = true;
        }
        result += DFS(name, 0, cnt, 0);
        return result;
    }

    public int makeLetter(char to) {
        return Math.min(to - 'A', Math.abs('Z' - to + 1));
    }

    public int DFS(String name, int now, int cnt, int sum) {
        if (cnt == name.length()) {
            return sum;
        }

        visited[now] = true;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < name.length(); i++) {
            if (!visited[i]) {
                int move;
                if (now > i) {
                    move = Math.min(now - i, i + name.length() - now);
                } else {
                    move = Math.min(i - now, now + name.length() - i);
                }
                min = Math.min(min, DFS(name, i, cnt + 1, sum + move));

            }
        }
        visited[now] = false;
        return min;
    }
}