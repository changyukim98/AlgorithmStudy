import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    // 메뉴와 주문한 사람의 인덱스를 담을 Order 클래스
    static class Order implements Comparable<Order> {
        int menu;
        int index;

        public Order(int menu, int index) {
            this.menu = menu;
            this.index = index;
        }
        
        // PriorityQueue에서 사용할 비교 메서드
        @Override
        public int compareTo(Order o) {
            if (this.menu == o.menu) {
                return this.index - o.index;
            } else return this.menu - o.menu;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        
        // 주문 큐와 메뉴 큐를 우선순위 큐로 생성한다.
        PriorityQueue<Order> orderQueue = new PriorityQueue<>();
        PriorityQueue<Integer> menuQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] orders = br.readLine().split(" ");
            for (int j = 1; j < orders.length; j++) {
                int menu = Integer.parseInt(orders[j]);
                orderQueue.offer(new Order(menu, i));
            }
        }
        
        String[] menus = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            menuQueue.offer(Integer.parseInt(menus[i]));
        }
        
        // i번째 손님이 음식을 몇번 먹었는지 확인할 배열
        int[] cnt = new int[N];
        while (!orderQueue.isEmpty() && !menuQueue.isEmpty()) {
            int menu = menuQueue.poll();

            while(!orderQueue.isEmpty()) {
                Order o  = orderQueue.peek();
                // 음식이 제공될 수 있다면 해당하는 사람의 cnt++
                if (o.menu == menu) {
                    cnt[o.index]++;
                    orderQueue.poll();
                    break;
                // 현재 음식이 menu의 우선순위보다 낮다면 menu만 버림
                } else if (o.menu > menu) {
                    break;
                // 현재 음식이 menu의 우선순위보다 높음
                // 음식이 제공될 수 없으므로 음식을 버림
                } else {
                    orderQueue.poll();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(cnt[i]).append(' ');
        }
        System.out.println(sb);
    }
}
