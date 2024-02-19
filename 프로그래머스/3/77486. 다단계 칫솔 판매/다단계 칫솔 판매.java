import java.util.*;

class Solution {
    private final Map<String, String> parentMap = new HashMap<>();
    private final Map<String, Integer> profitMap = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        for (int i = 0; i < enroll.length; i++) {
            String parent = referral[i];
            String child = enroll[i];

            parentMap.put(child, parent);
            profitMap.put(child, 0);
        }

        for (int i = 0; i < seller.length; i++) {
            propagation(seller[i], amount[i] * 100);
        }

        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            result[i] = profitMap.get(enroll[i]);
        }
        return result;
    }

    public void propagation(String person, int profit) {
        if (!parentMap.containsKey(person)) return;

        String parent = parentMap.get(person);
        int toParent = profit / 10;
        profitMap.put(person, profitMap.get(person) + profit - toParent);
        // 전달할 분배금이 0일 경우 정지, 안하면 시간 초과
        if (toParent != 0)
            propagation(parent, toParent);
    }
}