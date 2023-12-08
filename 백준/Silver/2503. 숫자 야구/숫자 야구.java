import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isUsed = new boolean[10];

        int[][] gameInfo = new int[N][3];
        for (int n = 0; n < N; n++) {
            String input = br.readLine();
            String[] info = input.split(" ");

            gameInfo[n][0] = Integer.parseInt(info[0]);
            gameInfo[n][1] = Integer.parseInt(info[1]);
            gameInfo[n][2] = Integer.parseInt(info[2]);
        }

        int cnt = 0;
        for (int i = 1; i < 10; i++) {
            isUsed[i] = true;
            for (int j = 1; j < 10; j++) {
                if (isUsed[j]) continue;
                isUsed[j] = true;
                for (int k = 1; k < 10; k++) {
                    if (isUsed[k]) continue;
                    isUsed[k] = true;
                    if (isPossible(gameInfo, new int[]{i, j, k})) {
                        cnt++;
                    }
                    isUsed[k] = false;
                }
                isUsed[j] = false;
            }
            isUsed[i] = false;
        }

        System.out.println(cnt);
    }

    public static boolean isPossible(int[][] gameInfo, int[] targetArray) {
        for (int n = 0; n < gameInfo.length; n++) {
            int strike = 0, ball = 0;
            int question = gameInfo[n][0];
            int[] questionArray = {question / 100, (question % 100) / 10, question % 10};

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (questionArray[i] == targetArray[j]) {
                        if (i == j) strike++;
                        else ball++;
                    }
                }
            }

            if (strike != gameInfo[n][1] || ball != gameInfo[n][2]) return false;
        }
        return true;
    }
}
