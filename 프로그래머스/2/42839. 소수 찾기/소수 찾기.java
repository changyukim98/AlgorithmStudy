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
        for (int i = 1; i <= numArray.length; i++) {
            perm(numArray, numCount, i, 0, 0);
        }
        
        int cnt = 0;
        for (Integer i : set) {
            if (isPrime(i)) cnt++;
        }
        return cnt;
    }

    public void perm(int[] numArray, int[] numCount, int r, int cur, int result) {
        if (cur == r) {
            set.add(result);
            return;
        }
        for (int i = 0; i < numArray.length; i++) {
            int num = numArray[i];
            if (numCount[num] > 0) {
                numCount[num]--;
                perm(numArray, numCount, r, cur + 1, result * 10 + num);
                numCount[num]++;
            }
        }
    }

    public boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}