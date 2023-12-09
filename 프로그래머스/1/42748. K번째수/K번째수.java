import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int left = commands[i][0];
            int right = commands[i][1];
            int k = commands[i][2];

            int[] sorted = Arrays.copyOfRange(array, left - 1, right);
            Arrays.sort(sorted);
            answer[i] = sorted[k - 1];
        }
        return answer;
    }
}
