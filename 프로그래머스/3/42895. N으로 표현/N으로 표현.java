import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] setArray = new Set[9];

        int num = N;
        for (int i = 1; i < 9; i++) {
            setArray[i] = new HashSet<>();
            setArray[i].add(num);
            num = num * 10 + N;
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (Integer a : setArray[j]) {
                    for (Integer b : setArray[k]) {
                        setArray[i].add(a + b);
                        setArray[i].add(a - b);
                        setArray[i].add(a * b);
                        if (b != 0) setArray[i].add(a / b);
                    }
                }
            }
            if (setArray[i].contains(number)) {
                return i;
            }
        }
        return -1;
    }
}