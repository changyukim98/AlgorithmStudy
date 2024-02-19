class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows + 1][columns + 1];

        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = num;
                num++;
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int top = queries[i][0];
            int left = queries[i][1];
            int bottom = queries[i][2];
            int right = queries[i][3];

            int temp = matrix[top][left];
            int min = temp;
            for (int y = top; y < bottom; y++) {
                matrix[y][left] = matrix[y + 1][left];
                min = Math.min(min, matrix[y][left]);

            }
            for (int x = left; x < right; x++) {
                matrix[bottom][x] = matrix[bottom][x + 1];
                min = Math.min(min, matrix[bottom][x]);
            }
            for (int y = bottom; y > top; y--) {
                matrix[y][right] = matrix[y - 1][right];
                min = Math.min(min, matrix[y][right]);
            }
            for (int x = right; x > left + 1; x--) {
                matrix[top][x] = matrix[top][x - 1];
                min = Math.min(min, matrix[top][x]);
            }
            matrix[top][left + 1] = temp;
            result[i] = min;
        }
        
        return result;
    }
}