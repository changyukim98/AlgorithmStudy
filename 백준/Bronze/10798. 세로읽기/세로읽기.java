import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] texts = new String[5];
        int maxLen = 0;
        for (int i = 0; i < 5; i++) {
            texts[i] = br.readLine();
            maxLen = Math.max(maxLen, texts[i].length());
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < maxLen; j++) {
            for (int i = 0; i < 5; i++) {
                if (texts[i].length() > j) {
                    sb.append(texts[i].charAt(j));
                }
            }
        }
        System.out.println(sb);
    }
}
