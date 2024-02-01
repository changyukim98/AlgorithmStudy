import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int cnt = 0;
        int camera = -30001;
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];

            if (camera < start) {
                camera = end;
                cnt++;
            }
        }

        return cnt;
    }
}
