import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] personInfo = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            personInfo[i][0] = Integer.parseInt(input[0]);
            personInfo[i][1] = Integer.parseInt(input[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int height = personInfo[i][0];
            int weight = personInfo[i][1];
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (personInfo[j][0] > height && personInfo[j][1] > weight) {
                    rank++;
                }
            }
            sb.append(rank).append(' ');
        }

        System.out.println(sb);
    }
}
