class Solution {
    public int solution(String s) {
        int answer = splitString(s, 0, 0);
        return answer;
    }

    public int splitString(String s, int i, int answer) {
        if (i >= s.length()) return answer;

        int cnt1 = 1, cnt2 = 0, len = s.length();
        char x = s.charAt(i);
        i++;

        for (; i < len; i++) {
            if (s.charAt(i) == x) {
                cnt1++;
            } else {
                cnt2++;
            }

            if (cnt1 == cnt2) {
                return splitString(s, i + 1, answer + 1);
            }
        }
        return answer + 1;
    }
}