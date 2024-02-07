import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int num : queue1){
            q1.add(num);
            sum1 += num;
        }
        for (int num : queue2) {
            q2.add(num);
            sum2 += num;
        }

        int cnt = 0;
        while (sum1 != sum2) {
            if (cnt >= queue1.length * 4) {
                cnt = -1;
                break;
            }
            if (sum1 < sum2) {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.add(q2.remove());
            } else {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.remove());
            }
            cnt++;
        }

        return cnt;
    }
}