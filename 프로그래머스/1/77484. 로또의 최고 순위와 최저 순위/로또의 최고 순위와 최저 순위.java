class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] isWinNum = new boolean[46];

        for (int winNum : win_nums) {
            isWinNum[winNum] = true;
        }

        int max = 0;
        int min = 0;
        for (int lottoNum : lottos) {
            if (lottoNum == 0) {
                max++;
            } else if (isWinNum[lottoNum]) {
                max++;
                min++;
            }
        }

        // 로또 등수로 변환
        max = max >= 2 ? 7 - max : 6;
        min = min >= 2 ? 7 - min : 6;

        return new int[]{max, min};
    }
}