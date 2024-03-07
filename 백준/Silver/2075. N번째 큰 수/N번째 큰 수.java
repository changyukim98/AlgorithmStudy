import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        for (int i = 0; i < N; i++) {
            String[] stringArray = br.readLine().split(" ");
            for (int j = 0; j < stringArray.length; j++) {
                pq.add(Integer.parseInt(stringArray[j]));
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = pq.poll();
        }
        System.out.println(result);
    }
}
