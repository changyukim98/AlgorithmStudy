import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        int N = Integer.parseInt(br.readLine());
        // 다솜의 득표수
        int dasomVotes = Integer.parseInt(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        if (pq.isEmpty()) {
            System.out.println(0);
        } else {
            int cnt = 0;
            while (true) {
                int maxVotes = pq.poll();
                if (maxVotes >= dasomVotes) {
                    maxVotes -= 1;
                    dasomVotes += 1;
                    pq.add(maxVotes);
                    cnt++;
                } else break;
            }
            System.out.println(cnt);
        }
    }
}
