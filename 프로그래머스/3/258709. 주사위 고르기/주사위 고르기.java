import java.util.*;

class Solution {
    private final List<int[][]> diceCombList = new ArrayList<>();

    public int[] solution(int[][] dice) {
        comb(dice.length, 0, 0, new int[2][dice.length / 2]);

        int max = 0;
        int[] result = new int[0];
        for (int[][] diceComb : diceCombList) {
            // 주사위 A에 대한 조합 합계들
            List<Integer> diceASumList = new ArrayList<>();
            List<Integer> diceBSumList = new ArrayList<>();

            getDicesSum(diceASumList, dice, diceComb[0], 0, 0);
            getDicesSum(diceBSumList, dice, diceComb[1], 0, 0);

            Collections.sort(diceBSumList);

            int sum = 0;
            for (Integer num : diceASumList) {
                int idx = binarySearch(diceBSumList, num, 0, diceBSumList.size() - 1);
                sum += idx + 1;
            }

            if (max < sum) {
                max = sum;
                result = diceComb[0];
            }
        }

        return result;
    }

    public void comb(int n, int cntA, int cntB, int[][] picked) {
        if (n == cntA + cntB) {
            int[][] temp = new int[2][n / 2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    temp[i][j] = picked[i][j];
                }
            }
            diceCombList.add(temp);
            return;
        }
        if (cntA < n / 2) {
            picked[0][cntA] = cntA + cntB + 1;
            comb(n, cntA + 1, cntB, picked);
        }
        if (cntB < n / 2) {
            picked[1][cntB] = cntA + cntB + 1;
            comb(n, cntA, cntB + 1, picked);
        }
    }

    public void getDicesSum(List<Integer> sumList, int[][] dice, int[] diceComb, int cur, int sum) {
        if (cur == diceComb.length) {
            sumList.add(sum);
            return;
        }
        for (int num : dice[diceComb[cur] - 1]) {
            getDicesSum(sumList, dice, diceComb, cur + 1, sum + num);
        }
    }

    public int binarySearch(List<Integer> list, int target, int start, int end) {
        if (start > end) return end;
        int mid = (start + end) / 2;
        if (target <= list.get(mid)) {
            return binarySearch(list, target, start, mid - 1);
        } else {
            return binarySearch(list, target, mid + 1, end);
        }
    }
}