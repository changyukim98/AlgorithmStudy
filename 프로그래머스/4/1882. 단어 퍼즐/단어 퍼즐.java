import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] strs, String t) {
        Set<String> words = new HashSet<>(Arrays.asList(strs));
        int len = t.length();
        int[] dp = new int[len + 1];

        Arrays.fill(dp, 20001);
        dp[0] = 0;
        // dp[i] <- i-1번까지 글자를 만들었을때 필요한 갯수
        for (int i = 1; i <= len; i++) {
            int j = Math.max(0, i - 5);
            for (; j < i; j++) {
                String sub = t.substring(j, i);
                if (words.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        if (dp[len] == 20001) return -1;
        else return dp[len];
    }
}