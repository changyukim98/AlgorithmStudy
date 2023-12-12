class Solution {
    public int[] solution(String[] wallpaper) {
        char[][] map = new char[wallpaper.length][];
        for (int i = 0; i < map.length; i++) {
            map[i] = wallpaper[i].toCharArray();
        }

        int x_min = 50, x_max = 0;
        int y_min = 50, y_max = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '#') {
                    x_min = Math.min(x_min, j);
                    x_max = Math.max(x_max, j);
                    y_min = Math.min(y_min, i);
                    y_max = Math.max(y_max, i);
                }
            }
        }

        int[] answer = {y_min, x_min, y_max + 1, x_max + 1};
        return answer;
    }
}