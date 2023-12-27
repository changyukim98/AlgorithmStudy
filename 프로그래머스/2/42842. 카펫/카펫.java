class Solution {
    public int[] solution(int brown, int yellow) {

        // (x - 2) * (y - 2) = yellow
        // xy - 2x - 2y + 4 = yellow
        // xy = yellow + brown
        // 2(yellow+brown)/y + 2y - 4 = brown
        // 2(yellow+brown) + 2y^2 - 4y = brown * y
        // 2y^2 - (4+brown)y +2(yellow+brown) = 0
        // y = 4+brown+sqrt((4+brown)^2-16(yellow+brown)) / 4

        int x = (4 + brown + (int) Math.sqrt((4 + brown) * (4 + brown) - 16 * (yellow + brown))) / 4;
        int y = (4 + brown - (int) Math.sqrt((4 + brown) * (4 + brown) - 16 * (yellow + brown))) / 4;
        return new int[]{x, y};
    }
}