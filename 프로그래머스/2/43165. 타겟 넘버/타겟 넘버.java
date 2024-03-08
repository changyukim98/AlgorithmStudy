class Solution {
    private int cnt = 0;

    public int solution(int[] numbers, int target) {
        DFS(numbers, 0, 0, target);
        return cnt;
    }

    private void DFS(int[] numbers, int cur, int result, int target) {
        if (cur == numbers.length) {
            if (result == target) {
                cnt++;
            }
            return;
        }

        DFS(numbers, cur + 1, result + numbers[cur], target);
        DFS(numbers, cur + 1, result - numbers[cur], target);
    }
}