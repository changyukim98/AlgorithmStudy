import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] tree;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        tree = new int[N];

        int emptyIdx = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i] == -1) emptyIdx = i;
        }
        nums[emptyIdx] = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        makeTree(nums, 0, N - 1, 0);
        visitPostOrder(N, 0);

        System.out.println(sb);
    }

    public static void visitPostOrder(int N, int node) {
        if (node >= N) return;
        visitPostOrder(N, node * 2 + 1);
        visitPostOrder(N, node * 2 + 2);
        sb.append(tree[node]).append(' ');
    }

    public static void makeTree(int[] nums, int start, int end, int node) {
        if (start > end) return;
        int mid = (start + end) / 2;
        tree[node] = nums[mid];
        makeTree(nums, start, mid - 1, node * 2 + 1);
        makeTree(nums, mid + 1, end, node * 2 + 2);
    }
}
