import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // i번째 자료구조가 queue인지 stack인지 저장할 배열
        int[] qsInfo = new int[N];

        String input = br.readLine();
        String[] infos = input.split(" ");
        for (int i = 0; i < N; i++) {
            qsInfo[i] = Integer.parseInt(infos[i]);
        }

        input = br.readLine();
        String[] elements = input.split(" ");
        // stack은 사실상 shift만 하므로 고려하지않고 queue 자료구조만 생각함.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = N - 1; i >= 0; i--) {
            int element = Integer.parseInt(elements[i]);
            // 자료구조가 queue일 경우에만 해당 원소를 새로운 queue에 삽입
            if (qsInfo[i] == 0) {
                queue.add(element);
            }
        }

        int M = Integer.parseInt(br.readLine());
        input = br.readLine();
        String[] numTexts = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(numTexts[i]);
            queue.add(num);
            sb.append(queue.poll()).append(' ');
        }

        System.out.println(sb);
    }

}
