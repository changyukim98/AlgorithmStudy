import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/20920
public class Main {
    static class Word {
        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        // 길이가 M이상인 단어를 map에 빈도수와 함께 기록
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() < M) continue;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        // 맵 순회하면서 list에 추가
        List<Word> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Word(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list, (x, y) -> {
            if (x.cnt == y.cnt) {
                if (x.word.length() == y.word.length()) {
                    return x.word.compareTo(y.word);
                }
                return y.word.length() - x.word.length();
            }
            return y.cnt - x.cnt;
        });

        StringBuilder sb = new StringBuilder();
        for (Word word : list) {
            sb.append(word.word).append('\n');
        }
        System.out.println(sb);
    }
}
