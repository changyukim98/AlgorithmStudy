class Solution {
    public int solution(int a, int b, int c) {
        int answer = a + b + c;
        int[] count = new int[7];

        count[a]++;
        count[b]++;
        count[c]++;

        int max = 0;
        for (int i = 1; i <= 6; i++) {
            max = Math.max(max, count[i]);
        }

        if (max >= 2) answer *= a * a + b * b + c * c;
        if (max == 3) answer *= a * a * a + b * b * b + c * c * c;

        return answer;
    }
}