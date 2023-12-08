import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] nums = new int[6];

        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int[] result = bruteForce(nums);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] bruteForce(int[] nums) {
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                int result1 = nums[0] * x + nums[1] * y;
                int result2 = nums[3] * x + nums[4] * y;
                if (result1 == nums[2] && result2 == nums[5])
                    return new int[]{x, y};
            }
        }
        return new int[]{-1000, -1000};
    }
}
