import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        int cnt = 0;
        for (int i = 0; i < n && cnt < n / 2; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            cnt++;
        }
        return cnt;
    }
}