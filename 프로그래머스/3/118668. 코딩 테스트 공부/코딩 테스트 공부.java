import java.util.Arrays;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        if (alp > maxAlp) alp = maxAlp;
        if (cop > maxCop) cop = maxCop;
        // maxAlp < alp, maxCop < cop 인경우 런타임 에러
        // int[][] dp = new int[maxAlp + 1][maxCop + 1];
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 999999);
        }
        dp[alp][cop] = 0;

        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                if (i + 1 <= maxAlp) dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                if (j + 1 <= maxCop) dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                // 문제를 풀면서 DP값 갱신
                for (int[] problem : problems) {
                    int alpReq = problem[0];
                    int copReq = problem[1];
                    int toAlp = i + problem[2];
                    int toCop = j + problem[3];
                    int cost = problem[4];

                    if (i < alpReq || j < copReq) continue;
                    if (toAlp > maxAlp) toAlp = maxAlp;
                    if (toCop > maxCop) toCop = maxCop;
                    dp[toAlp][toCop] = Math.min(dp[toAlp][toCop], dp[i][j] + cost);
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}