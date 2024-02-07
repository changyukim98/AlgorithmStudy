import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> arrayList = new ArrayList<>();

        for (String str : intStrs) {
            int val = Integer.parseInt(str.substring(s, s + l));
            if (val > k) {
                arrayList.add(val);
            }
        }

        int[] answer = new int[arrayList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}