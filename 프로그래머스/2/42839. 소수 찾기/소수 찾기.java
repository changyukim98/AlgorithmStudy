import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set;

    public int solution(String numbers) {
        int[] numArray = new int[numbers.length()];
        int[] numCount = new int[10];

        for (int i = 0; i < numbers.length(); i++) {
            int num = Character.getNumericValue(numbers.charAt(i));
            numArray[i] = num;
            numCount[num]++;
        }

        set = new HashSet<>();
        perm(numArray, numCount, 0, 0);
        return set.size();
    }

    public void perm(int[] numArray, int[] numCount, int cur, int result) {
        if (cur == numArray.length) {
            if (isPrimary(result)) {
                System.out.println(result);
                set.add(result);
            }
            return;
        }
        for (int i = 0; i < numArray.length; i++) {
            int num = numArray[i];
            if (numCount[num] > 0) {
                numCount[num]--;
                perm(numArray, numCount, cur + 1, result * 10 + num);
                numCount[num]++;
            }
        }
        perm(numArray, numCount, cur + 1, result);
    }


    public boolean isPrimary(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}