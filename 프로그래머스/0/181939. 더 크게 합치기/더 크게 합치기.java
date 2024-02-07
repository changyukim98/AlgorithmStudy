class Solution {
    public int solution(int a, int b) {
        String concat1 = String.valueOf(a) + String.valueOf(b);
        String concat2 = String.valueOf(b) + String.valueOf(a);

        int result1 = Integer.parseInt(concat1);
        int result2 = Integer.parseInt(concat2);
        int answer = Math.max(result1, result2);
        
        return answer;
    }
}