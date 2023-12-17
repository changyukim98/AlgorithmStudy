import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Map<String, Boolean> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (map.containsKey(input)) continue;
            map.put(input, true);
            list.add(input);
        }

        list.sort((a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            else return a.length()-  b.length();
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}