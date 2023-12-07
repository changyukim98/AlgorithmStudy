import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static class Order implements Comparable<Order> {
        int menu;
        int index;

        public Order(int menu, int index) {
            this.menu = menu;
            this.index = index;
        }

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

        int[] cnt = new int[N];
        while (!orderQueue.isEmpty() && !menuQueue.isEmpty()) {
            int menu = menuQueue.poll();

            while(!orderQueue.isEmpty()) {
                Order o  = orderQueue.peek();
                if (o.menu == menu) {
                    cnt[o.index]++;
                    orderQueue.poll();
                    break;
                } else if (o.menu > menu) {
                    break;
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
