import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> prQueue = new LinkedList<>();
        Queue<Integer> retQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            prQueue.add(progresses[i]);
        }

        int idx = 0, day = 1;
        while (true) {
            int cnt = 0;
            while (!prQueue.isEmpty() && prQueue.peek() + day * speeds[idx] >= 100) {
                prQueue.poll();
                cnt++;
                idx++;
            }
            if (cnt >= 1) retQueue.add(cnt);
            if (prQueue.isEmpty()) break;
            day++;
        }

        int[] answer = new int[retQueue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = retQueue.poll();
        }

        return answer;
    }
}