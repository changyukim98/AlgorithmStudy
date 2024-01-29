import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        Set<Integer> lostSet = new HashSet<>();
        for (int i : lost) {
            lostSet.add(i);
        }
        Set<Integer> reserveSet = new HashSet<>();
        for (int i : reserve) {
            reserveSet.add(i);
        }
        
        int cnt = 0;
        
        for (int i = 0; i < lost.length; i++) {
            if (reserveSet.contains(lost[i])) {
                lost[i] = -1;
                cnt++;
            }
        }
        for (int i = 0; i < reserve.length; i++) {
            if (lostSet.contains(reserve[i])) reserve[i] = -1;
        }

        int i = 0, j = 0;
        while (i < lost.length && j < reserve.length) {
            if (lost[i] == -1) {
                i++;
            }
            else if (reserve[j] == -1) {
                j++;
            }
            // 옷이 한치수보다 더 작은 경우
            else if (lost[i] < reserve[j] - 1) i++;
                // 옷이 한치수보다 더 큰 경우
            else if (lost[i] > reserve[j] + 1) j++;
            else {
                cnt++;
                i++;
                j++;
            }
        }

        return n - lost.length + cnt;
    }
}