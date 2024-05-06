import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");

        Arrays.sort(nums, (x1, x2) -> {
            String order1 = x1 + x2;
            String order2 = x2 + x1;
            return order2.compareTo(order1);
        });

        StringBuilder answer = new StringBuilder();
        if (nums[0].equals("0")) {
            System.out.println("0");
            return;
        }
        else {
            for (String num : nums) {
                answer.append(num);
            }
            System.out.println(answer);
        }
    }
}
