class Solution {
    private int cnt = 0;

    public int solution(int[] numbers, int target) {
        DFS(numbers, 0, target, 0);
        return cnt;
    }

    public void DFS(int[] numbers, int cur, int target, int result) {
        if (cur == numbers.length) {
            if (result == target) cnt++;
            return;
        }
        DFS(numbers, cur + 1, target, result + numbers[cur]);
        DFS(numbers, cur + 1, target, result - numbers[cur]);
    }
}