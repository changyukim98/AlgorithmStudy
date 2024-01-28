class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];

        dp[0] = new int[1];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            dp[i] = new int[i + 1];

            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        int result = 0;
        for (int num : dp[dp.length - 1]) {
            result = Math.max(result, num);
        }
        return result;
    }
}