public class Solution {
    public int[] solution(String[] park, String[] routes) {
        int y = 0, x = 0;
        int N = park.length, M = park[0].length();
        char[][] charMap = new char[N][];

        for (int i = 0; i < park.length; i++) {
            charMap[i] = park[i].toCharArray();
        }
        
        // 시작지점 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (charMap[i][j] == 'S') {
                    y = i;
                    x = j;
                    break;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] moveInfo = routes[i].split(" ");
            String direction = moveInfo[0];
            int distance = Integer.parseInt(moveInfo[1]);
            int delta = 0;

            switch (direction) {
                case "N":
                    break;
                case "W":
                    delta = 1;
                    break;
                case "E":
                    delta = 2;
                    break;
                case "S":
                    delta = 3;
                    break;
            }

            int[][] deltas = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            int newY = y, newX = x;

            if (y + deltas[delta][0] * distance < 0) continue;
            if (x + deltas[delta][1] * distance < 0) continue;
            if (y + deltas[delta][0] * distance >= N) continue;
            if (x + deltas[delta][1] * distance >= M) continue;

            boolean isPossible = true;
            for (int d = 0; d < distance; d++) {
                newY += deltas[delta][0];
                newX += deltas[delta][1];
                if (charMap[newY][newX] == 'X') {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                y = newY;
                x = newX;
            }
        }

        return new int[]{y, x};
    }
}