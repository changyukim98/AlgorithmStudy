class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[end_num - start_num + 1];
        for (int num = start_num, idx = 0; num <= end_num; num++, idx++) {
            answer[idx] = num;
        }
        return answer;
    }
}