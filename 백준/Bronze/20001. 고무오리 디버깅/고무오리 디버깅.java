import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        int problems = 0;
        while(true) {
            String input = br.readLine();
            if ("고무오리 디버깅 끝".equals(input)) break;
            if ("문제".equals(input)) {
                problems++;
            } else {
                if (problems == 0) problems += 2;
                else problems--;
            }
        }
        if (problems == 0) System.out.println("고무오리야 사랑해");
        else System.out.println("힝구");
    }
}
