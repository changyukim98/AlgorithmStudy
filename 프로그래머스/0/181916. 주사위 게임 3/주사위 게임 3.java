import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    class Dice {
        int num;
        int cnt;

        public Dice(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public int solution(int a, int b, int c, int d) {
        int[] nums = {a, b, c, d};
        int[] cnt = new int[7];

        for (int num : nums) {
            cnt[num]++;
        }

        List<Dice> list = new ArrayList<>();
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] > 0) list.add(new Dice(i, cnt[i]));
        }

        int answer;
        list.sort((x, y) -> {
            if (x.cnt == y.cnt) return x.num - y.num;
            else return y.cnt - x.cnt;
        });

        if (list.size() == 1) {
            int p = list.get(0).num;
            answer = 1111 * p;
        } else if (list.size() == 2) {
            if (list.get(0).cnt == 3) {
                int p = list.get(0).num;
                int q = list.get(1).num;
                answer = (10 * p + q) * (10 * p + q);
            } else {
                int p = list.get(0).num;
                int q = list.get(1).num;
                answer = (p + q) * Math.abs(p - q);
            }
        } else if (list.size() == 3) {
            int q = list.get(1).num;
            int r = list.get(2).num;
            answer = q * r;
        } else {
            answer = list.get(0).num;
        }

        return answer;
    }
}