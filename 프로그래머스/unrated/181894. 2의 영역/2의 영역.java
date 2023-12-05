class Solution {
    public int[] solution(int[] arr) {
        int left = -1, right = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 2) continue;
            if (left == -1) {
                left = i;
                right = i;
            } else {
                right = i;
            }
        }
        if (left == -1) return new int[]{-1};
        
        int[] answer = new int[right - left + 1];
        int answerIdx = 0;
        for (int i = left; i <= right; i++) {
            answer[answerIdx++] = arr[i];
        }
        return answer;
    }
}