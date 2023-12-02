public class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLen = t.length(), pLen = p.length();
        long pValue = Long.parseLong(p);

        for (int i = 0; i + pLen <= tLen; i++) {
            long subVal = Long.parseLong(t.substring(i, i + pLen));
            if (subVal <= pValue) answer++;
        }
        return answer;
    }
}