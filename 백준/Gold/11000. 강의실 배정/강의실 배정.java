import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] lecture : lectures) {
            if (pq.isEmpty()) {
                pq.offer(lecture[1]);
                continue;
            }
            Integer fastest = pq.peek();
            if (lecture[0] >= fastest) {
                pq.poll();
                pq.offer(lecture[1]);
            } else {
                pq.offer(lecture[1]);
            }
        }
        System.out.println(pq.size());
    }
}
