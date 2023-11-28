class Solution {
    public int solution(String s) {
        int answer = splitArray(s, 0, 0);
        return answer;
    }

    public int splitArray(String s, int i, int answer) {
        if (i >= s.length()) return answer;

        int cnt1 = 1, cnt2 = 0;
        char x = s.charAt(i);
        i++;

        for (; i < s.length(); i++) {
            if (s.charAt(i) == x) {
                cnt1++;
            } else {
                cnt2++;
            }

            if (cnt1 == cnt2) {
                return splitArray(s, i + 1, answer + 1);
            }
        }
        return answer + 1;
    }
}