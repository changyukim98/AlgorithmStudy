class Solution {
    public int solution(int a, int b) {
        String concat = String.valueOf(a) + String.valueOf(b);
        int concatNum = Integer.parseInt(concat);

        int answer = Math.max(2 * a * b, concatNum);
        return answer;
    }
}