import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int min = 1000000000;
    private static int max = -1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] remainOp = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            remainOp[i] = Integer.parseInt(st.nextToken());
        }
        bruteForce(nums, remainOp, 1, nums[0]);
        System.out.println(max);
        System.out.println(min);

    }

    public static void bruteForce(int[] nums, int[] remainOp, int cur, int nowVal) {
        if (cur == nums.length) {
            max = Math.max(max, nowVal);
            min = Math.min(min, nowVal);
        }

        if (remainOp[0] >= 1) {
            remainOp[0]--;
            bruteForce(nums, remainOp, cur + 1, nowVal + nums[cur]);
            remainOp[0]++;
        }
        if (remainOp[1] >= 1) {
            remainOp[1]--;
            bruteForce(nums, remainOp, cur + 1, nowVal - nums[cur]);
            remainOp[1]++;
        }
        if (remainOp[2] >= 1) {
            remainOp[2]--;
            bruteForce(nums, remainOp, cur + 1, nowVal * nums[cur]);
            remainOp[2]++;
        }
        if (remainOp[3] >= 1) {
            remainOp[3]--;
            bruteForce(nums, remainOp, cur + 1, nowVal / nums[cur]);
            remainOp[3]++;
        }
    }
}
