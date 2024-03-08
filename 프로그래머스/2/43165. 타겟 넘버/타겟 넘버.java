import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int cnt = 0;

    public int solution(int[] numbers, int target) {
//        DFS(numbers, 0, 0, target);
        BFS(numbers, target);
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

    private void BFS(int[] numbers, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] nextInfo = queue.poll();
            int cur = nextInfo[0];
            int sum = nextInfo[1];

            if (cur == numbers.length) {
                if (sum == target) {
                    cnt++;
                }
                continue;
            }
            queue.add(new int[]{cur + 1, sum + numbers[cur]});
            queue.add(new int[]{cur + 1, sum - numbers[cur]});
        }
    }
}