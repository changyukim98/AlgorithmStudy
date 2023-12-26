import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[][] way = new int[3][];
        way[0] = new int[]{1, 2, 3, 4, 5};
        way[1] = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        way[2] = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (way[0][i % way[0].length] == answers[i]) cnt[0]++;
            if (way[1][i % way[1].length] == answers[i]) cnt[1]++;
            if (way[2][i % way[2].length] == answers[i]) cnt[2]++;
        }

        int max = 0;
        for (int i = 0; i < cnt.length; i++) {
            max = Math.max(max, cnt[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (max == cnt[i]) list.add(i + 1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}