import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (set.contains(input)) list.add(input);
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder(list.size() + "\n");
        for (String s : list) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}
