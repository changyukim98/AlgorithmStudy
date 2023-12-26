class Solution {
    public int solution(int[][] sizes) {
        int walletWidth = 0;
        int walletHeight = 0;

        for (int i = 0; i < sizes.length; i++) {
            int big = Math.max(sizes[i][0], sizes[i][1]);
            int small = Math.min(sizes[i][0], sizes[i][1]);

            walletWidth = Math.max(walletWidth, big);
            walletHeight = Math.max(walletHeight, small);
        }

        return walletWidth * walletHeight;
    }
}