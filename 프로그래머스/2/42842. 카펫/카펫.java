class Solution {
    public int[] solution(int brown, int yellow) {

        // 2*width + 2*height -4 = brown
        // (width-2) * (height-2) = yellow
        // 3 <= width <= (brown - 2) / 2
        // 3 <= height <= (brown - 2) / 2
        for (int i = 3; i <= (brown - 2) / 2; i++) {
            for (int j = 3; j <= (brown - 2) / 2; j++) {
                if ((i + j) * 2 - 4 == brown && (i - 2) * (j - 2) == yellow) {
                    return new int[]{Math.max(i, j), Math.min(i, j)};
                }
            }
        }
        return null;
    }
}