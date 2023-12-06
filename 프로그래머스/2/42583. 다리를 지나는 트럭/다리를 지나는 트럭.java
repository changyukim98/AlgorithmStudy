import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리 위 상황을 묘사할 큐
        Queue<Integer> queue = new LinkedList<>();
        // 큐를 bridge_length 만큼 무게 0의 더미 트럭으로 채움
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        // 진행 시간
        int time = 0;
        // 다리에 가해질 무게
        int bridgeWeight = 0;
        // 모든 트럭을 다리에 올릴 때까지 반복
        for (int i = 0; i < truck_weights.length; ) {
            bridgeWeight -= queue.remove();
            // 이번 차를 다리에 올릴 수 있다면
            if (bridgeWeight + truck_weights[i] <= weight) {
                queue.add(truck_weights[i]);
                bridgeWeight += truck_weights[i];
                i++;
            } else {
                // 이번에 트럭을 올리지 못했다면 더미 트럭을 다리에 올림.
                queue.add(0);
            }
            // 매 시간마다 맨 앞의 트럭을 빼주어야함
            time++;
        }

        // 마지막 차가 올라간 뒤에 빠져나가기까지 bridge_length 만큼의 시간이 필요
        time += bridge_length;

        return time;
    }
}